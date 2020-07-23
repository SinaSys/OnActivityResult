package com.example.onactivityresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profile_photo.*


private const val REQUEST_CODE_IMAGE_PICK = 0

class ProfilePhotoFragment : Fragment(R.layout.fragment_profile_photo) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imv_choose_picture.setOnClickListener {
            val updatePic = UpdatePicture()
            updatePic.updateProfilePicture(requireContext())

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_IMAGE_PICK) {
            data?.data?.let {
                imv_choose_picture.setImageURI(it)
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}
