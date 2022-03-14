package main.petprojects

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener(this)

    }


    //Принимает значения, находит решение по методу ELECTRE, выводит на экран
    fun ELECTRE() {
        //Характеристики
        val ves = findViewById<EditText>(R.id.Ves)
        val effectiv = findViewById<EditText>(R.id.Effectiv)
        val proizvod = findViewById<EditText>(R.id.proizvod)
        val nadezn = findViewById<EditText>(R.id.nadezn)
        val zashih = findViewById<EditText>(R.id.zashih)
        val perenosim = findViewById<EditText>(R.id.perenos)
        val dostupn = findViewById<EditText>(R.id.dostupn)
        //Метод ELECTRE вывод
        val elec1 = findViewById<TextView>(R.id.elec1)
        val elec2 = findViewById<TextView>(R.id.elec2)
        val elec3 = findViewById<TextView>(R.id.elec3)
        val elec4 = findViewById<TextView>(R.id.elec4)
        val elec5 = findViewById<TextView>(R.id.elec5)

        var arr_ves = (ves.text).split(" ").toTypedArray()
        var arr_effectiv = (effectiv.text).split(" ").toTypedArray()
        var arr_proizvod = (proizvod.text).split(" ").toTypedArray()
        var arr_nadezn = (nadezn.text).split(" ").toTypedArray()
        var arr_zashih = (zashih.text).split(" ").toTypedArray()
        var arr_perenosim = (perenosim.text).split(" ").toTypedArray()
        var arr_dostupn = (dostupn.text).split(" ").toTypedArray()

        var matr: Array<Array<Double>> = Array(5, { Array(7, { 0.0 }) })

        //Заполнить первый столбец
        var i = 0
        var j = 0

        matr[i][0] = arr_ves[i].toDouble()
        matr[i][1] = arr_effectiv[i].toDouble()
        matr[i][2] = arr_proizvod[i].toDouble()
        matr[i][3] = arr_nadezn[i].toDouble()
        matr[i][4] = arr_zashih[i].toDouble()
        matr[i][5] = arr_perenosim[i].toDouble()
        matr[i][6] = arr_dostupn[i].toDouble()

        //Заполнить второй столбец
        i = 1

        matr[i][0] = arr_ves[i].toDouble()
        matr[i][1] = arr_effectiv[i].toDouble()
        matr[i][2] = arr_proizvod[i].toDouble()
        matr[i][3] = arr_nadezn[i].toDouble()
        matr[i][4] = arr_zashih[i].toDouble()
        matr[i][5] = arr_perenosim[i].toDouble()
        matr[i][6] = arr_dostupn[i].toDouble()

        //Заполнить третий столбец
        i = 2

        matr[i][0] = arr_ves[i].toDouble()
        matr[i][1] = arr_effectiv[i].toDouble()
        matr[i][2] = arr_proizvod[i].toDouble()
        matr[i][3] = arr_nadezn[i].toDouble()
        matr[i][4] = arr_zashih[i].toDouble()
        matr[i][5] = arr_perenosim[i].toDouble()
        matr[i][6] = arr_dostupn[i].toDouble()

        //Заполнить четвёртый столбец
        i = 3

        matr[i][0] = arr_ves[i].toDouble()
        matr[i][1] = arr_effectiv[i].toDouble()
        matr[i][2] = arr_proizvod[i].toDouble()
        matr[i][3] = arr_nadezn[i].toDouble()
        matr[i][4] = arr_zashih[i].toDouble()
        matr[i][5] = arr_perenosim[i].toDouble()
        matr[i][6] = arr_dostupn[i].toDouble()

        //Заполнить пятый столбец
        i = 4

        matr[i][0] = arr_ves[i].toDouble()
        matr[i][1] = arr_effectiv[i].toDouble()
        matr[i][2] = arr_proizvod[i].toDouble()
        matr[i][3] = arr_nadezn[i].toDouble()
        matr[i][4] = arr_zashih[i].toDouble()
        matr[i][5] = arr_perenosim[i].toDouble()
        matr[i][6] = arr_dostupn[i].toDouble()

        Log.d("abc", matr[0][0].toString())
        Log.d("abc", matr[0][1].toString())
        Log.d("abc", matr[0][2].toString())
        Log.d("abc", matr[0][3].toString())
        Log.d("abc", matr[0][4].toString())


//1. Умножить каждое значение на вес
        for (i in 0..4) {
            for (j in 1..6) {
                matr[i][j] *= matr[i][0]
            }
        }

        Log.d("abc", "just_matr: " + matr[0][0].toString())
        Log.d("abc", matr[0][1].toString())
        Log.d("abc", matr[0][2].toString())
        Log.d("abc", matr[0][3].toString())
        Log.d("abc", matr[0][4].toString())

        //2. Посчитать значение C BAR и найти матрицу с нулями и единицами

        var matr_for_C_bar: Array<Array<Double>> = Array(5, { Array(5, { 0.0 }) })
        //2.1 Сравнить каждую характеристику с каждой и суммировать веса
        var a = 0
        j = 0
        for (m in 1..5) {
            for (i in 1..6) {
                if (j == j + a) {
                    matr_for_C_bar[j][j + a] = 0.0
                    continue
                } else if (matr[j][i] >= matr[j + a][i]) {
                    matr_for_C_bar[j][j + a] += matr[j][0]
                } else if (matr[j][i] <= matr[j + a][i]) {
                    matr_for_C_bar[j + a][j] += matr[j + a][0]
                }
            }
            a++
        }
        a = 0
        j = 1
        for (m in 1..4) {
            for (i in 1..6) {
                if (j == j + a) {
                    matr_for_C_bar[j][j + a] = 0.0
                    continue
                } else if (matr[j][i] >= matr[j + a][i]) {
                    matr_for_C_bar[j][j + a] += matr[j][0]
                } else if (matr[j][i] <= matr[j + a][i]) {
                    matr_for_C_bar[j + a][j] += matr[j + a][0]
                }
            }
            a++
        }

        a = 0
        j = 2
        for (m in 1..3) {
            for (i in 1..6) {
                if (j == j + a) {
                    matr_for_C_bar[j][j + a] = 0.0
                    continue
                } else if (matr[j][i] >= matr[j + a][i]) {
                    matr_for_C_bar[j][j + a] += matr[j][0]
                } else if (matr[j][i] <= matr[j + a][i]) {
                    matr_for_C_bar[j + a][j] += matr[j + a][0]
                }
            }
            a++
        }

        a = 0
        j = 3
        for (m in 1..2) {
            for (i in 1..6) {
                if (j == j + a) {
                    matr_for_C_bar[j][j + a] = 0.0
                    continue
                } else if (matr[j][i] >= matr[j + a][i]) {
                    matr_for_C_bar[j][j + a] += matr[j][0]
                } else if (matr[j][i] <= matr[j + a][i]) {
                    matr_for_C_bar[j + a][j] += matr[j + a][0]
                }
            }
            a++
        }

        a = 0
        j = 4
        for (m in 1..1) {
            for (i in 1..6) {
                if (j == j + a) {
                    matr_for_C_bar[j][j + a] = 0.0
                    continue
                } else if (matr[j][i] >= matr[j + a][i]) {
                    matr_for_C_bar[j][j + a] += matr[j][0]
                } else if (matr[j][i] <= matr[j + a][i]) {
                    matr_for_C_bar[j + a][j] += matr[j + a][0]
                }
            }
            a++
        }


        Log.d("abc", "К этому шагу всё работает!!!!")
        Log.d("abc", matr_for_C_bar[0][1].toString())
        Log.d("abc", matr_for_C_bar[0][2].toString())
        Log.d("abc", matr_for_C_bar[0][3].toString())
        Log.d("abc", matr_for_C_bar[0][4].toString())

        //2.2 Посчитать значение C_BAR и сформировать матрицу нулей и единиц
        var C_BAR = 0.0
        for (i in 0..4) {
            for (j in 0..4) {
                C_BAR += matr_for_C_bar[i][j]
            }
        }
        C_BAR /= 25

        for (i in 0..4) {
            for (j in 0..4) {
                if (matr_for_C_bar[i][j] > C_BAR) {
                    matr_for_C_bar[i][j] = 1.0
                } else {
                    matr_for_C_bar[i][j] = 0.0
                }
            }
        }

        Log.d(
            "avv", "Этот шаг получился!"
        )


//3. Из основной матрицы составить матрицу содержащую разницу а1-а2 а1-3 и т.д.
        j = 0
        i = 1
        var a1_minus_a2 = arrayOf(
            matr[j][i] - matr[j + 1][i],
            matr[j][i + 1] - matr[j + 1][i + 1],
            matr[j][i + 2] - matr[j + 1][i + 2],
            matr[j][i + 3] - matr[j + 1][i + 3],
            matr[j][i + 4] - matr[j + 1][i + 4],
            matr[j][i + 5] - matr[j + 1][i + 5]
        )
        var a1_minus_a3 = arrayOf(
            matr[j][i] - matr[j + 2][i],
            matr[j][i + 1] - matr[j + 2][i + 1],
            matr[j][i + 2] - matr[j + 2][i + 2],
            matr[j][i + 3] - matr[j + 2][i + 3],
            matr[j][i + 4] - matr[j + 2][i + 4],
            matr[j][i + 5] - matr[j + 2][i + 5]
        )
        var a1_minus_a4 = arrayOf(
            matr[j][i] - matr[j + 3][i],
            matr[j][i + 1] - matr[j + 3][i + 1],
            matr[j][i + 2] - matr[j + 3][i + 2],
            matr[j][i + 3] - matr[j + 3][i + 3],
            matr[j][i + 4] - matr[j + 3][i + 4],
            matr[j][i + 5] - matr[j + 3][i + 5]
        )
        var a1_minus_a5 = arrayOf(
            matr[j][i] - matr[j + 4][i],
            matr[j][i + 1] - matr[j + 4][i + 1],
            matr[j][i + 2] - matr[j + 4][i + 2],
            matr[j][i + 3] - matr[j + 4][i + 3],
            matr[j][i + 4] - matr[j + 4][i + 4],
            matr[j][i + 5] - matr[j + 4][i + 5]
        )
        j = 1
        var a2_minus_a3 = arrayOf(
            matr[j][i] - matr[j + 1][i],
            matr[j][i + 1] - matr[j + 1][i + 1],
            matr[j][i + 2] - matr[j + 1][i + 2],
            matr[j][i + 3] - matr[j + 1][i + 3],
            matr[j][i + 4] - matr[j + 1][i + 4],
            matr[j][i + 5] - matr[j + 1][i + 5]
        )
        var a2_minus_a4 = arrayOf(
            matr[j][i] - matr[j + 2][i],
            matr[j][i + 1] - matr[j + 2][i + 1],
            matr[j][i + 2] - matr[j + 2][i + 2],
            matr[j][i + 3] - matr[j + 2][i + 3],
            matr[j][i + 4] - matr[j + 2][i + 4],
            matr[j][i + 5] - matr[j + 2][i + 5]
        )
        var a2_minus_a5 = arrayOf(
            matr[j][i] - matr[j + 3][i],
            matr[j][i + 1] - matr[j + 3][i + 1],
            matr[j][i + 2] - matr[j + 3][i + 2],
            matr[j][i + 3] - matr[j + 3][i + 3],
            matr[j][i + 4] - matr[j + 3][i + 4],
            matr[j][i + 5] - matr[j + 3][i + 5]
        )
        j = 2
        var a3_minus_a4 = arrayOf(
            matr[j][i] - matr[j + 1][i],
            matr[j][i + 1] - matr[j + 1][i + 1],
            matr[j][i + 2] - matr[j + 1][i + 2],
            matr[j][i + 3] - matr[j + 1][i + 3],
            matr[j][i + 4] - matr[j + 1][i + 4],
            matr[j][i + 5] - matr[j + 1][i + 5]
        )
        var a3_minus_a5 = arrayOf(
            matr[j][i] - matr[j + 2][i],
            matr[j][i + 1] - matr[j + 2][i + 1],
            matr[j][i + 2] - matr[j + 2][i + 2],
            matr[j][i + 3] - matr[j + 2][i + 3],
            matr[j][i + 4] - matr[j + 2][i + 4],
            matr[j][i + 5] - matr[j + 2][i + 5]
        )
        j = 3
        var a4_minus_a5 = arrayOf(
            matr[j][i] - matr[j + 1][i],
            matr[j][i + 1] - matr[j + 1][i + 1],
            matr[j][i + 2] - matr[j + 1][i + 2],
            matr[j][i + 3] - matr[j + 1][i + 3],
            matr[j][i + 4] - matr[j + 1][i + 4],
            matr[j][i + 5] - matr[j + 1][i + 5]
        )


        Log.d("avv", "работает")

        var count1 = 0.0
        var count2 = 0.0
        var count3 = 0.0
        var count4 = 0.0
        var count5 = 0.0


        for (i in 0..4) {
            count1 += matr_for_C_bar[0][i]
            count2 += matr_for_C_bar[1][i]
            count3 += matr_for_C_bar[2][i]
            count4 += matr_for_C_bar[3][i]
            count5 += matr_for_C_bar[4][i]
        }


        val counts = hashMapOf<String, Double>()
        counts["1\n"] = count1
        counts["2\n"] = count2
        counts["3\n"] = count3
        counts["4\n"] = count4
        counts["5\n"] = count5

        val sorted_counts = counts.toList().sortedBy { (k, v) -> v }

        Log.d("abc", counts["1\n"].toString())

        elec1.setText((sorted_counts[4].toString()[1]).toString() + "\n")
        elec2.setText((sorted_counts[3].toString()[1]).toString() + "\n")
        elec3.setText((sorted_counts[2].toString()[1]).toString() + "\n")
        elec4.setText((sorted_counts[1].toString()[1]).toString() + "\n")
        elec5.setText((sorted_counts[0].toString()[1]).toString() + "\n")


    }


    //Аналогично
    fun mainKrit() {

        //Характеристики
        val ves = findViewById<EditText>(R.id.Ves)
        val effectiv = findViewById<EditText>(R.id.Effectiv)
        val proizvod = findViewById<EditText>(R.id.proizvod)
        val nadezn = findViewById<EditText>(R.id.nadezn)
        val zashih = findViewById<EditText>(R.id.zashih)
        val perenosim = findViewById<EditText>(R.id.perenos)
        val dostupn = findViewById<EditText>(R.id.dostupn)

        //Метод главного критерия вывод
        val main_krit1 = findViewById<TextView>(R.id.mainKrit1)
        val main_krit2 = findViewById<TextView>(R.id.mainKrit2)
        val main_krit3 = findViewById<TextView>(R.id.mainKrit3)
        val main_krit4 = findViewById<TextView>(R.id.mainKrit4)
        val main_krit5 = findViewById<TextView>(R.id.mainKrit5)

        var arr_ves = (ves.text).split(" ").toTypedArray()
        var arr_effectiv = (effectiv.text).split(" ").toTypedArray()
        var arr_proizvod = (proizvod.text).split(" ").toTypedArray()
        var arr_nadezn = (nadezn.text).split(" ").toTypedArray()
        var arr_zashih = (zashih.text).split(" ").toTypedArray()
        var arr_perenosim = (perenosim.text).split(" ").toTypedArray()
        var arr_dostupn = (dostupn.text).split(" ").toTypedArray()

        var matr: Array<Array<Double>> = Array(9, { Array(5, { 0.0 }) })

        var j = 0
        // Представление данных в массиве, как на экране

        for (i in 0..4) {
            j = 0
            matr[j][i] = arr_ves[i].toDouble()
            matr[++j][i] = arr_effectiv[i].toDouble()
            matr[++j][i] = arr_proizvod[i].toDouble()
            matr[++j][i] = arr_nadezn[i].toDouble()
            matr[++j][i] = arr_zashih[i].toDouble()
            matr[++j][i] = arr_perenosim[i].toDouble()
            matr[++j][i] = arr_dostupn[i].toDouble()
            matr[++j][i] = (i + 1).toDouble()
            matr[++j][i] = i.toDouble()
        }
        Log.d("abc", "Функция swap работает")

        var countIsAlright: Int = 0
        j = 0
        0
        for (i in 0..4) {
            if (isAllRight(
                    matr[j][i], matr[j + 1][i], matr[j + 3][i], matr[j + 4][i], matr[j + 5][i],
                    matr[j + 6][i]
                )
            ) {
                countIsAlright++
            }
        }

        for (i1 in 0..3) {
            for (i2 in i1 + 1..4) {
                if (!isAllRight(
                        matr[j][i1],
                        matr[j + 1][i1],
                        matr[j + 3][i1],
                        matr[j + 4][i1],
                        matr[j + 5][i1],
                        matr[j + 6][i1]
                    ) and isAllRight(
                        matr[j][i2],
                        matr[j + 1][i2],
                        matr[j + 3][i2],
                        matr[j + 4][i2],
                        matr[j + 5][i2],
                        matr[j + 6][i2]
                    )
                ) {
                    swap((matr[j + 8][i1]).toInt(), (matr[j + 8][i2]).toInt(), matr)
                }
            }
        }

        Log.d("main_krit", "its_work")


        for (i in 0..countIsAlright - 1) {
            for (j in i + 1..countIsAlright) {
                if (matr[2][i] < matr[2][j]) swap(matr[8][i].toInt(), matr[8][j].toInt(), matr)
            }
        }
        Log.d("main_krit", "its_work")

        //Вывод

        main_krit1.text = matr[7][0].toInt().toString()
        main_krit2.text = matr[7][1].toInt().toString()
        main_krit3.text = matr[7][2].toInt().toString()
        main_krit4.text = matr[7][3].toInt().toString()
        main_krit5.text = matr[7][4].toInt().toString()

    }

    private fun swap(el1Number: Int, el2Number: Int, matr: Array<Array<Double>>) {
        val i1: Int = el1Number
        val i2: Int = el2Number

        var j = 0

        var c_Arr: Array<Double> = arrayOf(
            matr[j][i1], matr[j + 1][i1], matr[j + 2][i1], matr[j + 3][i1],
            matr[j + 4][i1], matr[j + 5][i1], matr[j + 6][i1], matr[j + 7][i1]
        )

        j = 0

        for (j in 0..7) matr[j][i1] = matr[j][i2]
        for (j in 0..7) matr[j][i2] = c_Arr[j]

    }

    private fun isAllRight(
        ves: Double,
        eff: Double,
        nad: Double,
        zash: Double,
        peren: Double,
        dos: Double
    ): Boolean {
        if (ves >= 0.15 && eff > 0.15 && nad > 0.15 && zash > 0.15 && peren > 0.15 && dos > 0.15) return true
        else return false
    }

    //Аналогично
    fun idealPoint() {
        //Характеристики
        val ves = findViewById<EditText>(R.id.Ves)
        val effectiv = findViewById<EditText>(R.id.Effectiv)
        val proizvod = findViewById<EditText>(R.id.proizvod)
        val nadezn = findViewById<EditText>(R.id.nadezn)
        val zashih = findViewById<EditText>(R.id.zashih)
        val perenosim = findViewById<EditText>(R.id.perenos)
        val dostupn = findViewById<EditText>(R.id.dostupn)

        //Метод идеальной точки вывод
        val ideal_point1 = findViewById<TextView>(R.id.perfectPoint1)
        val ideal_point2 = findViewById<TextView>(R.id.perfectPoint2)
        val ideal_point3 = findViewById<TextView>(R.id.perfectPoint3)
        val ideal_point4 = findViewById<TextView>(R.id.perfectPoint4)
        val ideal_point5 = findViewById<TextView>(R.id.perfectPoint5)

        var arr_ves = (ves.text).split(" ").toTypedArray()
        var arr_effectiv = (effectiv.text).split(" ").toTypedArray()
        var arr_proizvod = (proizvod.text).split(" ").toTypedArray()
        var arr_nadezn = (nadezn.text).split(" ").toTypedArray()
        var arr_zashih = (zashih.text).split(" ").toTypedArray()
        var arr_perenosim = (perenosim.text).split(" ").toTypedArray()
        var arr_dostupn = (dostupn.text).split(" ").toTypedArray()

        var matr: Array<Array<Double>> = Array(10, { Array(5, { 0.0 }) })

        var j = 0
        // Представление данных в массиве, как на экране

        for (i in 0..4) {
            j = 0
            matr[j][i] = arr_ves[i].toDouble()
            matr[++j][i] = arr_effectiv[i].toDouble()
            matr[++j][i] = arr_proizvod[i].toDouble()
            matr[++j][i] = arr_nadezn[i].toDouble()
            matr[++j][i] = arr_zashih[i].toDouble()
            matr[++j][i] = arr_perenosim[i].toDouble()
            matr[++j][i] = arr_dostupn[i].toDouble()
            matr[++j][i] = (i + 1).toDouble()
            matr[++j][i] = i.toDouble()
        }

        //Поиск максимальных значений
        j = 0
        val max_ves = matr[j].toList().maxOrNull()
        val max_effectiv = matr[++j].toList().maxOrNull()
        val max_proizvod = matr[++j].toList().maxOrNull()
        val max_nadezn = matr[++j].toList().maxOrNull()
        val max_zashih = matr[++j].toList().maxOrNull()
        val max_perenos = matr[++j].toList().maxOrNull()
        val max_dostupn = matr[++j].toList().maxOrNull()

        j = 0
        for (i in 0..4) {
            matr[j + 9][i] = Math.pow(matr[j][i] - max_ves!!.toDouble(), 2.0) +
                    Math.pow(matr[j + 1][i] - max_effectiv!!.toDouble(), 2.0) +
                    Math.pow(matr[j + 2][i] - max_proizvod!!.toDouble(), 2.0) +
                    Math.pow(matr[j + 3][i] - max_nadezn!!.toDouble(), 2.0) +
                    Math.pow(matr[j + 4][i] - max_zashih!!.toDouble(), 2.0) +
                    Math.pow(matr[j + 5][i] - max_perenos!!.toDouble(), 2.0) +
                    Math.pow(matr[j + 6][i] - max_dostupn!!.toDouble(), 2.0)
        }

        for (i in 0..3) {
            for (j in i + 1..4) {
                if (matr[9][i] > matr[9][j]) swap(matr[8][i].toInt(), matr[8][j].toInt(), matr)
            }
        }
        Log.d("ideal_point", "its work")


        //Вывод

        ideal_point1.text = matr[7][0].toInt().toString()
        ideal_point2.text = matr[7][1].toInt().toString()
        ideal_point3.text = matr[7][2].toInt().toString()
        ideal_point4.text = matr[7][3].toInt().toString()
        ideal_point5.text = matr[7][4].toInt().toString()
    }

    //Возвращает экран к первоначальному состоянию
    @SuppressLint("SetTextI18n")
    fun clearResult() {
        //Метод ELECTRE вывод
        val elec1 = findViewById<TextView>(R.id.elec1)
        val elec2 = findViewById<TextView>(R.id.elec2)
        val elec3 = findViewById<TextView>(R.id.elec3)
        val elec4 = findViewById<TextView>(R.id.elec4)
        val elec5 = findViewById<TextView>(R.id.elec5)
        //Метод главного критерия вывод
        val main_krit1 = findViewById<TextView>(R.id.mainKrit1)
        val main_krit2 = findViewById<TextView>(R.id.mainKrit2)
        val main_krit3 = findViewById<TextView>(R.id.mainKrit3)
        val main_krit4 = findViewById<TextView>(R.id.mainKrit4)
        val main_krit5 = findViewById<TextView>(R.id.mainKrit5)
        //Метод идеальной точки вывод
        val ideal_point1 = findViewById<TextView>(R.id.perfectPoint1)
        val ideal_point2 = findViewById<TextView>(R.id.perfectPoint2)
        val ideal_point3 = findViewById<TextView>(R.id.perfectPoint3)
        val ideal_point4 = findViewById<TextView>(R.id.perfectPoint4)
        val ideal_point5 = findViewById<TextView>(R.id.perfectPoint5)

        elec1.text = "1\n"
        elec2.text = "2\n"
        elec3.text = "3\n"
        elec4.text = "4\n"
        elec5.text = "5\n"

        main_krit1.text = "1\n"
        main_krit2.text = "2\n"
        main_krit3.text = "3\n"
        main_krit4.text = "4\n"
        main_krit5.text = "5\n"

        ideal_point1.text = "1\n"
        ideal_point2.text = "2\n"
        ideal_point3.text = "3\n"
        ideal_point4.text = "4\n"
        ideal_point5.text = "5\n"
    }


    override fun onClick(p0: View?) {

        if (p0 != null) {
            val bt = findViewById<Button>(p0.id)
            if (bt.text == "Найти решение") {
                ELECTRE()
                mainKrit()
                idealPoint()
                bt.text = "Сбросить"
            } else {
                clearResult()
                bt.text = "Найти решение"
            }
        }
    }
}