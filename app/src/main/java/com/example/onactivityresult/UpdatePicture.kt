package com.example.onactivityresult

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri



private const val REQUEST_CODE_IMAGE_PICK = 0

class UpdatePicture {

     fun updateProfilePicture(context: Context) {
        Intent(Intent.ACTION_GET_CONTENT).also {
            it.type = "image/*"
            //startActivityForResult(it, REQUEST_CODE_IMAGE_PICK)
            (context as Activity).startActivityForResult(it, REQUEST_CODE_IMAGE_PICK)
        }
    }

}