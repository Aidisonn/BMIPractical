package taruc.edu.bmipractical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageViewBMI: ImageView = findViewById(R.id.imageViewBMI)
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val textViewStatus: TextView = findViewById(R.id.textViewStatus)
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)

        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonReset: Button = findViewById((R.id.buttonReset))

        buttonCalculate.setOnClickListener{
             if(editTextHeight.text.isEmpty()){
                 editTextHeight.setError(getString(R.string.value_required))
                 return@setOnClickListener
             }
            if(editTextWeight.text.isEmpty()){
                editTextWeight.setError(getString(R.string.value_required))
                return@setOnClickListener
            }

            if(editTextHeight.text.toString().toFloat() <= 0){
                editTextHeight.setError(getString(R.string.value_zero))
                return@setOnClickListener
            }
            if(editTextWeight.text.toString().toFloat() <= 0){
                editTextWeight.setError(getString(R.string.value_zero))
                return@setOnClickListener
            }

            var weight = editTextWeight.text.toString().toFloat()
            var height = editTextHeight.text.toString().toFloat()

            var bmi = weight / (height/100).pow(2)

            if(bmi < 18.5){ //underweight
                imageViewBMI.setImageResource(R.drawable.under)
            }

            if(bmi < 18.5){ //underweight
                imageViewBMI.setImageResource(R.drawable.under)
            }

            if(bmi < 18.5){ //underweight
                imageViewBMI.setImageResource(R.drawable.under)
                //BOdy Mass Index : 18.92
                textViewBMI.text = String.format("%s : %.2f", getString(R.string.bmi), bmi)
                //Status : UnderWeight
                textViewStatus.text = String.format("%s", "Status : Underweight")
            }

            else if(bmi >= 18.5 && bmi < 25){ //Normal
                imageViewBMI.setImageResource(R.drawable.normal)
                //BOdy Mass Index : 18.92
                textViewBMI.text = String.format("%s : %.2f", getString(R.string.bmi), bmi)
                //Status : Normal
                textViewStatus.text = String.format("%s", "Status : Normal")
            }

            else if(bmi > 25){ //Overweighta
                imageViewBMI.setImageResource(R.drawable.over)
                //BOdy Mass Index : 18.92
                textViewBMI.text = String.format("%s : %.2f", getString(R.string.bmi), bmi)
                //Status : Overweight
                textViewStatus.text = String.format("%s", "Status : Overweight")
            }

        }
        buttonReset.setOnClickListener {
            imageViewBMI.setImageResource((R.drawable.empty))
            editTextHeight.text.clear();
            editTextWeight.text.clear();
            textViewBMI.text = ""
            textViewStatus.text = ""

        }


    }
}