package com.example.new_calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textview.MaterialTextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import kotlin.math.exp

class MainActivity : AppCompatActivity() {
    lateinit var resultado: MaterialTextView
    lateinit var expressao: MaterialTextView
    lateinit var num0: MaterialTextView
    lateinit var num1: MaterialTextView
    lateinit var num2: MaterialTextView
    lateinit var num3: MaterialTextView
    lateinit var num4: MaterialTextView
    lateinit var num5: MaterialTextView
    lateinit var num6: MaterialTextView
    lateinit var num7: MaterialTextView
    lateinit var num8: MaterialTextView
    lateinit var num9: MaterialTextView
    lateinit var mais: MaterialTextView
    lateinit var menos: MaterialTextView
    lateinit var multiplica: MaterialTextView
    lateinit var divide: MaterialTextView
    lateinit var limpar: MaterialTextView
    lateinit var apaga: MaterialTextView
    lateinit var ponto: MaterialTextView
    lateinit var igual: MaterialTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultado = findViewById(R.id.resultado)
        expressao = findViewById(R.id.expressao)
        num0 = findViewById(R.id.num0)
        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        num3 = findViewById(R.id.num3)
        num4 = findViewById(R.id.num4)
        num5 = findViewById(R.id.num5)
        num6 = findViewById(R.id.num6)
        num7 = findViewById(R.id.num7)
        num8 = findViewById(R.id.num8)
        num9 = findViewById(R.id.num9)
        mais = findViewById(R.id.mais)
        menos = findViewById(R.id.menos)
        multiplica = findViewById(R.id.multiplica)
        divide = findViewById(R.id.dividir)
        limpar = findViewById(R.id.limpar)
        apaga = findViewById(R.id.apaga)
        ponto = findViewById(R.id.ponto)
        igual = findViewById(R.id.igual)
        supportActionBar!!.hide()

        num0.setOnClickListener{acrescrentarExpressao("0",true)}
        num1.setOnClickListener{acrescrentarExpressao("1",true)}
        num2.setOnClickListener{acrescrentarExpressao("2",true)}
        num3.setOnClickListener{acrescrentarExpressao("3",true)}
        num4.setOnClickListener{acrescrentarExpressao("4",true)}
        num5.setOnClickListener{acrescrentarExpressao("5",true)}
        num6.setOnClickListener{acrescrentarExpressao("6",true)}
        num7.setOnClickListener{acrescrentarExpressao("7",true)}
        num8.setOnClickListener{acrescrentarExpressao("8",true)}
        num9.setOnClickListener{acrescrentarExpressao("9",true)}
        ponto.setOnClickListener{acrescrentarExpressao(".",true)}

        mais.setOnClickListener { acrescrentarExpressao("+",false) }
        menos.setOnClickListener { acrescrentarExpressao("-",false) }
        multiplica.setOnClickListener { acrescrentarExpressao("*",false) }
        divide.setOnClickListener { acrescrentarExpressao("/",false) }

        limpar.setOnClickListener {
            expressao.text = ""
            resultado.text = ""
        }
        apaga.setOnClickListener {
            val str = expressao.text.toString()
            if (str.isNotBlank()){
                expressao.text = str.substring(0,str.length-1)
            }
            resultado.text = ""
        }
        igual.setOnClickListener {
            try {
                val expressao = ExpressionBuilder(expressao.text.toString()).build()
                val resultado1 = expressao.evaluate()
                val longResultado = resultado1.toLong()

                if (resultado1 == longResultado.toDouble()){
                    resultado.text = longResultado.toString()
                }else{
                    resultado.text = resultado1.toString()
                }
            }catch (e: Exception){

            }
        }
    }
    private fun acrescrentarExpressao(str: String, limparDados:Boolean){
            if(resultado.text.isNotEmpty()){
                expressao.text = ""
            }
            if (limparDados){
                resultado.text = ""
                expressao.append(str)
            }else{
                expressao.append(resultado.text)
                expressao.append(str)
                resultado.text = ""
            }
        }
    }