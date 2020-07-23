package com.example.onactivityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


private const val REQUEST_CODE_IMAGE_PICK = 0

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /**
         *
         * UpdatePicture is a custom class with method name : updateProfilePicture() inside it
         * and in this method we choose picture from gallery with the help of
         * startActivityForResult and send it to this class (Main Activity)
         * and in this class with the help of onActivityResult method we
         * retrieve the image and shown that in imageView
         */
        imv_choose_picture.setOnClickListener {
            val updatePic = UpdatePicture()
            updatePic.updateProfilePicture(this)

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_IMAGE_PICK) {
            data?.data?.let {
                imv_choose_picture.setImageURI(it)
            }
        }
    }
}
