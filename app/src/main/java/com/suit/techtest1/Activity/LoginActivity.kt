package com.suit.techtest1.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.suit.techtest1.Extension.isPalindrome
import com.suit.techtest1.Extension.showToast
import com.suit.techtest1.Model.Person

import com.suit.techtest1.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.recyclerview_guest.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bindAction()
    }

    fun bindAction() {
        submitButton.setOnClickListener {
            isPalindrome()
            goToChooseActivity()
        }
    }

    fun goToChooseActivity() {
        val intent = Intent(this@LoginActivity, ChooseActionActivity::class.java);
        intent.putExtra("info", getInfo())
        startActivity(intent);
    }

    fun getInfo(): Person {
        return Person(txtEdit.text.toString())
    }

    fun isPalindrome() {
        if (txtEdit.text.toString().isPalindrome()) {
            showToast("isPalindrome")
        } else {
            showToast("not palindromet")
        }
    }
}
