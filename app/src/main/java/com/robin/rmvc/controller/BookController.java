package com.robin.rmvc.controller;

import com.robin.rmvc.R;
import com.robin.rmvc.bean.Book;
import com.robin.rmvc.model.BookModel;

import java.util.List;

/**
 * Created by Robin on 2018/7/11.
 */

public class BookController {
    private BookModel mode;
    public BookController() {
        mode = new BookModel();
    }

    /**
     * 添加书本
     * @param listener
     */
    public void add(onAddBookListener listener) {
        mode.addBook("JavaWeb从入门到精通", R.drawable.javaweb);
        if (listener != null) {
            listener.onComplete();
        }
    }

    /**
     * 删除书本
     * @param listener
     */
    public void delete(onDeleteBookListener listener) {
        if(mode.query().isEmpty()){
            return;
        }else{
            mode.deleteBook();
        }
        if (listener != null) {
            listener.onComplete();
        }
    }

    /**
     * 查询所有书本
     * @return
     */
    public List<Book> query() {
        return mode.query();
    }

    /**
     * 添加成功的回调接口
     */
    public interface onAddBookListener {
        void onComplete();
    }

    /**
     * 删除成功的回调接口
     */
    public interface onDeleteBookListener {
        void onComplete();
    }
}
