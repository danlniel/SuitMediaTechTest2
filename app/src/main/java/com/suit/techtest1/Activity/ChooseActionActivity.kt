package com.suit.techtest1.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.suit.techtest1.Extension.isNull
import com.suit.techtest1.Model.GlobalName
import com.suit.techtest1.R
import kotlinx.android.synthetic.main.activity_choose_action.*

/**
 * Created by Daniel on 1/27/2018.
 */
class ChooseActionActivity : AppCompatActivity() {
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent);
        getInfo()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_action)
        onNewIntent(intent)
        bindAction()
    }

    fun bindAction() {
        btnChooseEvent.setOnClickListener() {
            goToEvent()
        }

        btnChooseQuest.setOnClickListener() {
            goToQuest()
        }
    }

    fun getInfo() {
        val _object = intent.getParcelableExtra<GlobalName>("info")
        if (!_object.isNull()) {
            refreshLayout(_object)
        }
    }

    fun refreshLayout(result: GlobalName) {
        inputNameLabel.setText(result.name)
    }

    fun goToEvent() {
        val intent = Intent(this@ChooseActionActivity, EventActivity::class.java);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent);
    }

    fun goToQuest() {
        val intent = Intent(this@ChooseActionActivity, GuestActivity::class.java);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent);
    }
}
