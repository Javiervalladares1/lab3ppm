import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora1.Calculator
import com.example.calculadora1.R

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Asegúrate de usar el nombre correcto de tu archivo XML

        // Inicializar el display
        display = findViewById(R.id.display)

        // Configurar cada botón
        val buttons = listOf(
            R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
            R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7,
            R.id.button_8, R.id.button_9, R.id.button_AC, R.id.button_sqr,
            R.id.button_exp, R.id.button_divide, R.id.button_x, R.id.button_subs,
            R.id.button_add, R.id.button_parizq, R.id.button_parder, R.id.button_equal
        )

        buttons.forEach { buttonId ->
            findViewById<Button>(buttonId).setOnClickListener { handleButtonClick(it) }
        }
    }

    private fun handleButtonClick(view: android.view.View) {
        when (view.id) {
            R.id.button_equal -> try {
                val result = Calculator.evaluate(display.text.toString())
                display.text = result.toString()
            } catch (e: Exception) {
                display.text = "Error"
            }
            R.id.button_AC -> display.text = ""
            else -> {
                val button = view as Button
                display.text = buildString {
                    append(display.text)
                    append(button.text)
                }
            }
        }
    }
}