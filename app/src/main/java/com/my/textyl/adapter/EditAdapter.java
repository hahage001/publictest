package com.my.textyl.adapter;


import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.my.textyl.R;
import com.my.textyl.bean.EditBean;

import java.util.List;

/**
 * Created by 66km on 2018/7/3.
 */

public class EditAdapter extends BaseAdapter implements View.OnTouchListener {
    public Context context;
    List<EditBean> list;
    public int editItemPosition1 = -1;//-1 无焦点
    public int editItemPosition2 = -1;//-1 无焦点

    public EditAdapter(Context context, List<EditBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.editlayout, null);
            viewHolder = new ViewHolder();
            viewHolder.edit1 = convertView.findViewById(R.id.id_edit1);
            viewHolder.edit2 = convertView.findViewById(R.id.id_edit2);
            viewHolder.total = convertView.findViewById(R.id.id_total);
            //获取单价输入框焦点
            viewHolder.edit1.setOnTouchListener(this);
            //获取数量输入框焦点
            viewHolder.edit2.setOnTouchListener(this);
            viewHolder.mTextWatcher = new MyTextChangeWatch();
            viewHolder.mTextWatcher2 = new MyTextChangeWatch2();
            //设置数据监听  测试版本
            viewHolder.edit1.addTextChangedListener(viewHolder.mTextWatcher);
            viewHolder.edit2.addTextChangedListener(viewHolder.mTextWatcher2);

            viewHolder.upDataPosition(position);
            viewHolder.upDataPosition2(position);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            //获取单价输入框焦点
            viewHolder.edit1.setOnTouchListener(this);
            //获取数量输入框焦点
            viewHolder.edit2.setOnTouchListener(this);
            viewHolder.upDataPosition(position);
            viewHolder.upDataPosition2(position);
        }
        //输入框输入数字监听
//        editListener(viewHolder, position);


        viewHolder.edit1.setTag(position);
        viewHolder.edit2.setTag(position);


        viewHolder.edit1.setText(list.get(position).getEdit1() + "");
        viewHolder.edit2.setText(list.get(position).getEdit2() + "");
        viewHolder.total.setText(list.get(position).getTotal() + "");





        //输入框 输入时 焦点保持不变
        focusShow(position, viewHolder);


        return convertView;
    }


    /**
     * 焦点 指定到具体控件
     */
    private void focusShow(int i, ViewHolder viewHolder) {
        viewHolder.edit1.setTag(i);
        viewHolder.edit2.setTag(i);


        if (editItemPosition1 == i) {
            viewHolder.edit1.requestFocus();
            viewHolder.edit1.setSelection(viewHolder.edit1.getText().length());
        } else {
            viewHolder.edit1.clearFocus();
        }
        if (editItemPosition2 == i) {
            viewHolder.edit2.requestFocus();
            viewHolder.edit2.setSelection(viewHolder.edit2.getText().length());
        } else {
            viewHolder.edit2.clearFocus();
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //viewgroup只有当其子类控件不需要获取焦点时才获取焦点
        ((ViewGroup) v.getParent()).setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
        int tag = (Integer) v.getTag();
        switch (v.getId()) {
            case R.id.id_edit1:
                editItemPosition1 = tag;
                editItemPosition2 = -1;
                break;
            case R.id.id_edit2:
                editItemPosition2 = tag;
                editItemPosition1 = -1;
                break;

        }
        return false;
    }

    class ViewHolder {
        EditText edit1, edit2;
        TextView total;

        MyTextChangeWatch mTextWatcher;
        MyTextChangeWatch2 mTextWatcher2;

        //记录position,防止数据复用时,错乱
        public void upDataPosition(int position) {
            mTextWatcher.upDataPosition(position);
        } //记录position,防止数据复用时,错乱

        public void upDataPosition2(int position) {
            mTextWatcher2.upDataPosition2(position);
        }

    }
    class MyTextChangeWatch implements TextWatcher{
        private int position;

        public void upDataPosition(int position) {
            this.position = position;
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            try {
                String danjia = s.toString().trim();
                onItemEditListener.editListener(danjia,list.get(position).getEdit2(),position);
            } catch (Exception e) {

            }
        }
    }
    class MyTextChangeWatch2 implements TextWatcher {
        private int position;

        public void upDataPosition2(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            try {
                String gongshi = s.toString().trim();
                onItemEditListener.editListener(list.get(position).getEdit1(),gongshi,position);
//                    onMyGoodsClickListener.onBtnGoodsListener(id, list.get(id).getUnitprice(), gongshi, list.get(id).getDiscountprice());
            } catch (Exception e) {

            }
        }
    }

    public interface OnItemEditListener{
        void editListener(String s1,String s2,int position);
    }
    OnItemEditListener onItemEditListener;
    public void setOnItemEditListener(OnItemEditListener onItemEditListener){
        this.onItemEditListener = onItemEditListener;
    }
}
