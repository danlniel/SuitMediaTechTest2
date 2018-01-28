package com.suit.techtest1.Extension

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

/**
 * Created by Daniel on 1/28/2018.
 */

fun FragmentManager.inTransaction(transaction: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.transaction()
    fragmentTransaction.commit()
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction {
        add(frameId, fragment)
    }
}

fun AppCompatActivity.addWithBackStackFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction {
        add(frameId, fragment)
        addToBackStack(null)
    }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction{ replace(frameId, fragment)}
}

fun AppCompatActivity.popBackFragment() {
    supportFragmentManager.popBackStack()
}

fun AppCompatActivity.removeFragment(fragment: Fragment) {
    supportFragmentManager.inTransaction {
        remove(fragment)
    }
}
