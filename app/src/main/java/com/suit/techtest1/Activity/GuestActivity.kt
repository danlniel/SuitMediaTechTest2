package com.suit.techtest1.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout
import com.suit.techtest1.Adapter.RecyclerGuestAdapter
import com.suit.techtest1.Helper.Constant.Companion.GRID_SPACING
import com.suit.techtest1.Helper.GridSpacingItemDecoration
import com.suit.techtest1.Model.Person
import com.suit.techtest1.Network.SearchApiDataProvider
import com.suit.techtest1.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_guest.*

/**
 * Created by Daniel on 1/27/2018.
 */
class GuestActivity : AppCompatActivity() {
    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    var listPerson = arrayListOf<Person>()
    val adapter by lazy {
        RecyclerGuestAdapter(listPerson) {
            backToChooseActivity(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest)
        setupRecycleView()
        setupPullToRefresh()
        fetchData()
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    fun setupRecycleView() {
        recycleView.layoutManager = GridLayoutManager(this, 2)
        recycleView.addItemDecoration(GridSpacingItemDecoration(GRID_SPACING))
        recycleView.adapter = adapter
    }

    fun fetchData() {
        val repository = SearchApiDataProvider.provideSearchApiData()
        compositeDisposable.add(
                repository.getGuest()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe ({
                            result ->
                            refreshCollectionView(result)
                        }, { error ->
                            error.printStackTrace()
                        })
        )
    }

    fun refreshCollectionView(listPerson: ArrayList<Person>) {
        adapter.refreshData(listPerson)
        showSwipeLoading(false)
    }

    fun backToChooseActivity(person: Person) {
        val intent = Intent(this@GuestActivity, ChooseActionActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        intent.putExtra("info", person)
        startActivity(intent)
        finish()
    }

    fun setupPullToRefresh() {
        layout_swipe_refresh.setOnRefreshListener(SwipyRefreshLayout.OnRefreshListener { direction ->
            fetchData();
        })
    }

    fun showSwipeLoading(active: Boolean) {
        layout_swipe_refresh.isRefreshing = active
    }
}