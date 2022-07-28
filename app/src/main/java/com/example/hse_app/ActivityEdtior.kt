package com.example.hse_app

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.GsonBuilder


class ActivityEditor : AppCompatActivity(), View.OnTouchListener {
    private var dX : Float = 0.toFloat()
    private var dY : Float = 0.toFloat()
    var current_bouquet : Bouquets = Bouquets("null")
    var all_id : MutableList<Int> = ArrayList()
    var all_types : MutableList<Flowers> = ArrayList()
    var global_id = 1
    lateinit var cur_name : String

    override fun onCreate(savedInstanceState: Bundle?) {
        // удаление цветков за границей экрана
        // свайпает в неправильную сторону
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Editor"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        cur_name = intent.getStringExtra("name") ?: ""
        var raw : String? = intent.getStringExtra("bouq") ?: null
        if (raw != null) {
            val gson = GsonBuilder().create()
            current_bouquet = gson.fromJson(raw, Bouquets::class.java)
        }
        display_existed()
    }

    fun display_existed() {
        for (i in current_bouquet.current_flowers) {
            var newView: ImageView
            newView = ImageView(this)
            var create_layout: ConstraintLayout = findViewById(R.id.create_layout)
            create_layout.addView(newView)
            newView.layoutParams.height = 300
            newView.layoutParams.width = 300
            newView.setId(global_id)
            global_id += 1
            newView.setOnTouchListener(this)
            if (i.name == Flowers.rose) {
                newView.setImageResource(R.drawable.rose)
                newView.x = i.x
                newView.y = i.y
            } else if (i.name == Flowers.chamomile) {
                newView.setImageResource(R.drawable.chamomile)
                newView.x = i.x
                newView.y = i.y
            } else if (i.name == Flowers.carnation) {
                newView.setImageResource(R.drawable.carnation)
                newView.x = i.x
                newView.y = i.y
            } else if (i.name == Flowers.chrysanthemum) {
                newView.setImageResource(R.drawable.chrysanthemum)
                newView.x = i.x
                newView.y = i.y
            } else if (i.name == Flowers.peony) {
                newView.setImageResource(R.drawable.peony)
                newView.x = i.x
                newView.y = i.y
            } else if (i.name == Flowers.iris) {
                newView.setImageResource(R.drawable.iris)
                newView.x = i.x
                newView.y = i.y
            } else if (i.name == Flowers.lily) {
                newView.setImageResource(R.drawable.lily)
                newView.x = i.x
                newView.y = i.y
            } else if (i.name == Flowers.hortensia) {
                newView.setImageResource(R.drawable.hortensia)
                newView.x = i.x
                newView.y = i.y
            } else if (i.name == Flowers.sunflower) {
                newView.setImageResource(R.drawable.sunflower)
                newView.x = i.x
                newView.y = i.y
            }
            else if (i.name == Flowers.gypsophila) {
                newView.setImageResource(R.drawable.gypsophila)
                newView.x = i.x
                newView.y = i.y
            }
            else if (i.name == Flowers.ruscus) {
                newView.setImageResource(R.drawable.ruscus)
                newView.x = i.x
                newView.y = i.y
            }
            else if (i.name == Flowers.dianthus) {
                newView.setImageResource(R.drawable.dianthus)
                newView.x = i.x
                newView.y = i.y
            }
            else if (i.name == Flowers.trachelium) {
                newView.setImageResource(R.drawable.trachelium)
                newView.x = i.x
                newView.y = i.y
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_save) {
            for (i in 0 until current_bouquet.current_flowers.size) {
                current_bouquet.current_flowers[i].x = findViewById<ImageView>(i + 1).x
                current_bouquet.current_flowers[i].y = findViewById<ImageView>(i + 1).y
            }
            for (i in 0 until all_id.size) {
                var current_flower: Flower = Flower(
                    all_types[i],
                    findViewById<ImageView>(all_id[i]).x,
                    findViewById<ImageView>(all_id[i]).y,
                    findViewById<ImageView>(all_id[i]).height
                )
                if (all_types[i] == Flowers.rose) current_bouquet.cnt_flowers[0] += 1
                else if (all_types[i] == Flowers.chamomile) current_bouquet.cnt_flowers[1] += 1
                else if (all_types[i] == Flowers.carnation) current_bouquet.cnt_flowers[2] += 1
                else if (all_types[i] == Flowers.chrysanthemum) current_bouquet.cnt_flowers[3] += 1
                else if (all_types[i] == Flowers.peony) current_bouquet.cnt_flowers[4] += 1
                else if (all_types[i] == Flowers.iris) current_bouquet.cnt_flowers[5] += 1
                else if (all_types[i] == Flowers.lily) current_bouquet.cnt_flowers[6] += 1
                else if (all_types[i] == Flowers.hortensia) current_bouquet.cnt_flowers[7] += 1
                else if (all_types[i] == Flowers.sunflower) current_bouquet.cnt_flowers[8] += 1
                else if (all_types[i] == Flowers.ruscus) current_bouquet.cnt_flowers[9] += 1
                else if (all_types[i] == Flowers.dianthus) current_bouquet.cnt_flowers[10] += 1
                else if (all_types[i] == Flowers.trachelium) current_bouquet.cnt_flowers[10] += 1
                current_bouquet.current_flowers += current_flower
            }
            val dialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.bottom_sheet_save_no_name, null)
            val btnClose = view.findViewById<Button>(R.id.idBtnDismiss)
            val btnSave = view.findViewById<Button>(R.id.idBtnAccept)
            val txtv = view.findViewById<TextView>(R.id.idTVCourseTracks)
            txtv.setText("Total flowers: ${current_bouquet.all_cnt}")
            btnClose.setOnClickListener {
                dialog.dismiss()
            }
            btnSave.setOnClickListener {
                MySave(current_bouquet)
                dialog.dismiss()
                val new_activity = Intent(this@ActivityEditor, ActivityView::class.java)
                new_activity.putExtra("name", current_bouquet.name)
                startActivity(new_activity)
            }
            dialog.setCancelable(false) // false
            dialog.setContentView(view)
            dialog.show()
        }
        else if (item.itemId == R.id.action_delete) {
            if (all_id.size != 0) {
                var newView: ImageView = findViewById(global_id - 1)
                var create_layout: ConstraintLayout = findViewById(R.id.create_layout)
                create_layout.removeView(newView)
                global_id -= 1
                current_bouquet.all_cnt -= 1
                all_id.removeLast()
                all_types.removeLast()
            }
        }
        else if (item.itemId != R.id.filter_flowers) {
            var newView: ImageView
            newView = ImageView(this)
            var create_layout: ConstraintLayout = findViewById(R.id.create_layout)
            create_layout.addView(newView)
            newView.layoutParams.height = 300
            newView.layoutParams.width = 300
            newView.setId(global_id)
            all_id += global_id
            global_id += 1
            current_bouquet.all_cnt += 1
            newView.setOnTouchListener(this)
            if (item.itemId == R.id.action_rose) {
                newView.setImageResource(R.drawable.rose)
                newView.x = (this.getResources()
                    .getDisplayMetrics().widthPixels / 2 - newView.layoutParams.height / 2).toFloat()
                newView.y = (this.getResources()
                    .getDisplayMetrics().heightPixels / 2 - newView.layoutParams.width / 2).toFloat()
                all_types += Flowers.rose
            } else if (item.itemId == R.id.action_chamomile) {
                newView.setImageResource(R.drawable.chamomile)
                newView.x = (this.getResources()
                    .getDisplayMetrics().widthPixels / 2 - newView.layoutParams.height / 2).toFloat()
                newView.y = (this.getResources()
                    .getDisplayMetrics().heightPixels / 2 - newView.layoutParams.width / 2).toFloat()
                all_types += Flowers.chamomile
            } else if (item.itemId == R.id.action_carnation) {
                newView.setImageResource(R.drawable.carnation)
                newView.layoutParams.height = 320
                newView.layoutParams.width = 320
                newView.x = (this.getResources()
                    .getDisplayMetrics().widthPixels / 2 - newView.layoutParams.height / 2).toFloat()
                newView.y = (this.getResources()
                    .getDisplayMetrics().heightPixels / 2 - newView.layoutParams.width / 2).toFloat()
                all_types += Flowers.carnation
            } else if (item.itemId == R.id.action_chrysanthemum) {
                newView.setImageResource(R.drawable.chrysanthemum)
                newView.layoutParams.height = 340
                newView.layoutParams.width =340
                newView.x = (this.getResources()
                    .getDisplayMetrics().widthPixels / 2 - newView.layoutParams.height / 2).toFloat()
                newView.y = (this.getResources()
                    .getDisplayMetrics().heightPixels / 2 - newView.layoutParams.width / 2).toFloat()
                all_types += Flowers.chrysanthemum
            } else if (item.itemId == R.id.action_peony) {
                newView.setImageResource(R.drawable.peony)
                newView.layoutParams.height = 300
                newView.layoutParams.width = 300
                newView.x = (this.getResources()
                    .getDisplayMetrics().widthPixels / 2 - newView.layoutParams.height / 2).toFloat()
                newView.y = (this.getResources()
                    .getDisplayMetrics().heightPixels / 2 - newView.layoutParams.width / 2).toFloat()
                all_types += Flowers.peony
            } else if (item.itemId == R.id.action_iris) {
                newView.setImageResource(R.drawable.iris)
                newView.layoutParams.height = 280
                newView.layoutParams.width = 280
                newView.x = (this.getResources()
                    .getDisplayMetrics().widthPixels / 2 - newView.layoutParams.height / 2).toFloat()
                newView.y = (this.getResources()
                    .getDisplayMetrics().heightPixels / 2 - newView.layoutParams.width / 2).toFloat()
                all_types += Flowers.iris
            } else if (item.itemId == R.id.action_lily) {
                newView.setImageResource(R.drawable.lily)
                newView.layoutParams.height = 280
                newView.layoutParams.width = 280
                newView.x = (this.getResources()
                    .getDisplayMetrics().widthPixels / 2 - newView.layoutParams.height / 2).toFloat()
                newView.y = (this.getResources()
                    .getDisplayMetrics().heightPixels / 2 - newView.layoutParams.width / 2).toFloat()
                all_types += Flowers.lily
            } else if (item.itemId == R.id.action_hortensia) {
                newView.setImageResource(R.drawable.hortensia)
                newView.layoutParams.height = 340
                newView.layoutParams.width = 340
                newView.x = (this.getResources()
                    .getDisplayMetrics().widthPixels / 2 - newView.layoutParams.height / 2).toFloat()
                newView.y = (this.getResources()
                    .getDisplayMetrics().heightPixels / 2 - newView.layoutParams.width / 2).toFloat()
                all_types += Flowers.hortensia
            } else if (item.itemId == R.id.action_sunflower) {
                newView.setImageResource(R.drawable.sunflower)
                newView.layoutParams.height = 380
                newView.layoutParams.width = 380
                newView.x = (this.getResources()
                    .getDisplayMetrics().widthPixels / 2 - newView.layoutParams.height / 2).toFloat()
                newView.y = (this.getResources()
                    .getDisplayMetrics().heightPixels / 2 - newView.layoutParams.width / 2).toFloat()
                all_types += Flowers.sunflower
            }
            else if (item.itemId == R.id.action_gypsophila) {
                newView.setImageResource(R.drawable.gypsophila)
                newView.layoutParams.height = 450
                newView.layoutParams.width = 450
                newView.x = (this.getResources()
                    .getDisplayMetrics().widthPixels / 2 - newView.layoutParams.height / 2).toFloat()
                newView.y = (this.getResources()
                    .getDisplayMetrics().heightPixels / 2 - newView.layoutParams.width / 2).toFloat()
                all_types += Flowers.gypsophila
            }
            else if (item.itemId == R.id.action_ruscus) {
                newView.setImageResource(R.drawable.ruscus)
                newView.layoutParams.height = 500
                newView.layoutParams.width = 500
                newView.x = (this.getResources()
                    .getDisplayMetrics().widthPixels / 2 - newView.layoutParams.height / 2).toFloat()
                newView.y = (this.getResources()
                    .getDisplayMetrics().heightPixels / 2 - newView.layoutParams.width / 2).toFloat()
                all_types += Flowers.ruscus
            }
            else if (item.itemId == R.id.action_dianthus) {
                newView.setImageResource(R.drawable.dianthus)
                newView.layoutParams.height = 400
                newView.layoutParams.width = 400
                newView.x = (this.getResources()
                    .getDisplayMetrics().widthPixels / 2 - newView.layoutParams.height / 2).toFloat()
                newView.y = (this.getResources()
                    .getDisplayMetrics().heightPixels / 2 - newView.layoutParams.width / 2).toFloat()
                all_types += Flowers.dianthus
            }
            else if (item.itemId == R.id.action_trachelium) {
                newView.setImageResource(R.drawable.trachelium)
                newView.layoutParams.height = 320
                newView.layoutParams.width = 320
                newView.x = (this.getResources()
                    .getDisplayMetrics().widthPixels / 2 - newView.layoutParams.height / 2).toFloat()
                newView.y = (this.getResources()
                    .getDisplayMetrics().heightPixels / 2 - newView.layoutParams.width / 2).toFloat()
                all_types += Flowers.trachelium
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                dX = view.x - event.rawX
                dY = view.y - event.rawY
            }
            MotionEvent.ACTION_MOVE -> view.animate()
                .x(event.rawX + dX)
                .y(event.rawY + dY)
                .setDuration(0)
                .start()
            else -> return false
        }
        return true
    }

    fun MySave(bouq : Bouquets) {
        val gson = GsonBuilder().create()
        var pref = getSharedPreferences(bouq.name, Context.MODE_PRIVATE)
        pref.edit()
            .putString("Bouquet", gson.toJson(bouq))
            .apply()
    }

}


