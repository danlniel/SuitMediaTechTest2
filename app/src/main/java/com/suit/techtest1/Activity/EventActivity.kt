package com.suit.techtest1.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.google.android.gms.location.places.ui.PlacePicker
import com.suit.techtest1.Adapter.RecyclerViewAdapter
import com.suit.techtest1.Extension.*
import com.suit.techtest1.Fragment.FragmentDetail
import com.suit.techtest1.Helper.Constant.Companion.PLACE_PICKER_REQUEST
import com.suit.techtest1.Model.Event
import com.suit.techtest1.Persistence.Persistence
import com.suit.techtest1.R
import kotlinx.android.synthetic.main.activity_event.*

class EventActivity : AppCompatActivity() {
    val fragDetail by lazy { FragmentDetail() }
    val adapter by lazy {
        RecyclerViewAdapter(Persistence.shared.listEvent) {
            showInfo(it)
            isPrime(it)
            backToChooseActivity(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        setListAdapter()
        setButton()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                val place = PlacePicker.getPlace(this, data)
                fragDetail.addPlace(place)
            }
        }
    }

    fun setButton() {
        addButton.setOnClickListener() {
            showMapFragment()
        }

        backButton.setOnClickListener() {
            backAction()
        }

        searchButton.setOnClickListener() {
            serachAction()
        }
    }

    fun serachAction() {
        if (fragDetail.isVisible) {
            loadPlacePicker()
        } else {
            showToast("Please open map fragment first")
        }
    }

    fun backAction() {
        if (fragDetail.isVisible) {
            popBackFragment()
        } else {
            onBackPressed()
        }
    }

    fun showMapFragment() {
        if (!fragDetail.isAdded) {
            addWithBackStackFragment(fragDetail, R.id.bottomContainer)
        }
    }

    fun setListAdapter() {
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = adapter
    }

    fun backToChooseActivity(event: Event) {
        val intent = Intent(this@EventActivity, ChooseActionActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        intent.putExtra("info", event)
        startActivity(intent)
        finish()
    }

    fun showInfo(event: Event) {
        val day = event.date.getDayFrom()
        if ((day%2).isZero() && (day%3).isZero()) {
            showToast("ios")
        } else if ((day%3).isZero()) {
            showToast("android")
        } else if ((day%2).isZero()) {
            showToast("blackberry")
        } else {
            showToast("feature phone")
        }
    }

    fun isPrime(event: Event) {
        val month = event.date.getMonthFrom()
        if (month.isPrime()) {
            Log.d("0", "isPrime")
        } else {
            Log.d("0", "not prime")
        }
    }
}
