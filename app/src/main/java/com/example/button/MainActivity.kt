package com.example.button

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggleButtonGroup.addOnButtonCheckedListener { toggleButtonGroup, checkedId, isChecked ->
            if (isChecked){
                when(checkedId){
                    R.id.button2 -> Toast.makeText(this@MainActivity, button2.text, Toast.LENGTH_SHORT)
                            .show()
                    R.id.button3 -> showToast(button3.text.toString())
                    R.id.button4 -> showToast(button4.text.toString())
                    R.id.button5-> showToast(button5.text.toString())
                }
            }
            else{
                if (toggleButtonGroup.checkedButtonId == View.NO_ID){
                    showToast("Nothing Selected")
                }
            }
        }
        //new one






    }

    fun showAlertDialog (view: View){
        MaterialAlertDialogBuilder(this)
            .setTitle("Alert")
            .setMessage("Launching in 3 2 1 ....")
            .setNeutralButton("Remind me later"
            ) { dialog, which -> showSnackbar("System is cooled down")
            }
            .setNegativeButton("No"){
                    dialog, which -> showclickme(view)
            }
            .setPositiveButton("Yes"){dialog, which -> showSnackbar("Missile Lauched")}
            .show()

    }


    var selectedEmailIndec = 0

    fun showclickme (view: View){
        val emails = arrayOf("None","ude.chekw@gmail.com", "user2@gmail.com", "uersdsd2@gmail.com")

        var selectedEmail = emails[selectedEmailIndec]

        MaterialAlertDialogBuilder(this)
            .setTitle("Alert")
           // .setItems(emails){dialog, which ->
            //    when(which){
             //       0 -> showSnackbar("${emails[0]} Selected")
             //       1 -> showToast("${emails[1]} Selected")
             //       2 -> showSnackbar("${emails[2]} Selected")
             //   }
            .setSingleChoiceItems(emails,selectedEmailIndec){
                dialog,which ->
                selectedEmailIndec = which
                selectedEmail = emails[which]
            }
            .setPositiveButton("ok"){dialog, which ->
                showSnackbar("$selectedEmail Selected")
            }
            .setNeutralButton("Cancel"){dialog, which ->

            }
            .show()

    }

    private fun showSnackbar(msg:String){
        Snackbar.make(alert, msg ,Snackbar.LENGTH_SHORT).show()
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}