package com.jcpp.droidbook.dao;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table BOOK_AUTHOR.
 */
public class BookAuthor {

    private Long id;
    private long bookId;
    private long AuthorId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient BookAuthorDao myDao;

    private Book book;
    private Long book__resolvedKey;

    private Author author;
    private Long author__resolvedKey;


    public BookAuthor() {
    }

    public BookAuthor(Long id) {
        this.id = id;
    }

    public BookAuthor(Long id, long bookId, long AuthorId) {
        this.id = id;
        this.bookId = bookId;
        this.AuthorId = AuthorId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBookAuthorDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(long AuthorId) {
        this.AuthorId = AuthorId;
    }

    /** To-one relationship, resolved on first access. */
    public Book getBook() {
        long __key = this.bookId;
        if (book__resolvedKey == null || !book__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BookDao targetDao = daoSession.getBookDao();
            Book bookNew = targetDao.load(__key);
            synchronized (this) {
                book = bookNew;
            	book__resolvedKey = __key;
            }
        }
        return book;
    }

    public void setBook(Book book) {
        if (book == null) {
            throw new DaoException("To-one property 'bookId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.book = book;
            bookId = book.getId();
            book__resolvedKey = bookId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Author getAuthor() {
        long __key = this.AuthorId;
        if (author__resolvedKey == null || !author__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AuthorDao targetDao = daoSession.getAuthorDao();
            Author authorNew = targetDao.load(__key);
            synchronized (this) {
                author = authorNew;
            	author__resolvedKey = __key;
            }
        }
        return author;
    }

    public void setAuthor(Author author) {
        if (author == null) {
            throw new DaoException("To-one property 'AuthorId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.author = author;
            AuthorId = author.getId();
            author__resolvedKey = AuthorId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
