package com.simon.study.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.simon.study.R
import com.simon.study.view.wordmagnifier.EWListView
import android.R.menu
import com.simon.study.view.wordmagnifier.EWListViewChildET
import android.support.design.widget.CoordinatorLayout.Behavior.setTag
import android.view.*
import com.simon.study.MainActivity
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.act_ewview.*

/**
 *   created by simon
 *   date 2018/6/26
 *   description:
 *   version code 1.0
 */
class WordMagnifierAct:AppCompatActivity() {

    private lateinit var poetry: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_ewview)
        //init data
        val res = resources
        poetry = res.getStringArray(R.array.poetry)
        ewlv.adapter = EwlvAdapter()
    }

    internal inner class EwlvAdapter : BaseAdapter() {

        override fun getCount(): Int {
            return poetry.count()
        }

        override fun getItem(position: Int): Any? {
            return position
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            var view = convertView
            val verse = poetry[position]
            val holder: ViewHolder
            if (view == null) {
                view = LayoutInflater.from(this@WordMagnifierAct).inflate(R.layout.ewlv_item, null)
                holder = ViewHolder()
                holder.ewe_text = view.findViewById(R.id.ewe_text)
                view!!.tag = holder
            } else {
                holder = view.tag as ViewHolder
            }
            holder.ewe_text.setText(verse)
            return convertView
        }
    }

    internal inner class ViewHolder {
        lateinit var ewe_text: EWListViewChildET
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.getItemId()


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}