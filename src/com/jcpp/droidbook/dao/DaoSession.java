package com.jcpp.droidbook.dao;

import java.util.Map;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig bookDaoConfig;
    private final DaoConfig authorDaoConfig;
    private final DaoConfig bookAuthorDaoConfig;
    private final DaoConfig shelveDaoConfig;
    private final DaoConfig bookShelveDaoConfig;
    private final DaoConfig categoryDaoConfig;
    private final DaoConfig bookCategoryDaoConfig;
    private final DaoConfig noteDaoConfig;
    private final DaoConfig quoteDaoConfig;

    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final BookAuthorDao bookAuthorDao;
    private final ShelveDao shelveDao;
    private final BookShelveDao bookShelveDao;
    private final CategoryDao categoryDao;
    private final BookCategoryDao bookCategoryDao;
    private final NoteDao noteDao;
    private final QuoteDao quoteDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        bookDaoConfig = daoConfigMap.get(BookDao.class).clone();
        bookDaoConfig.initIdentityScope(type);

        authorDaoConfig = daoConfigMap.get(AuthorDao.class).clone();
        authorDaoConfig.initIdentityScope(type);

        bookAuthorDaoConfig = daoConfigMap.get(BookAuthorDao.class).clone();
        bookAuthorDaoConfig.initIdentityScope(type);

        shelveDaoConfig = daoConfigMap.get(ShelveDao.class).clone();
        shelveDaoConfig.initIdentityScope(type);

        bookShelveDaoConfig = daoConfigMap.get(BookShelveDao.class).clone();
        bookShelveDaoConfig.initIdentityScope(type);

        categoryDaoConfig = daoConfigMap.get(CategoryDao.class).clone();
        categoryDaoConfig.initIdentityScope(type);

        bookCategoryDaoConfig = daoConfigMap.get(BookCategoryDao.class).clone();
        bookCategoryDaoConfig.initIdentityScope(type);

        noteDaoConfig = daoConfigMap.get(NoteDao.class).clone();
        noteDaoConfig.initIdentityScope(type);

        quoteDaoConfig = daoConfigMap.get(QuoteDao.class).clone();
        quoteDaoConfig.initIdentityScope(type);

        bookDao = new BookDao(bookDaoConfig, this);
        authorDao = new AuthorDao(authorDaoConfig, this);
        bookAuthorDao = new BookAuthorDao(bookAuthorDaoConfig, this);
        shelveDao = new ShelveDao(shelveDaoConfig, this);
        bookShelveDao = new BookShelveDao(bookShelveDaoConfig, this);
        categoryDao = new CategoryDao(categoryDaoConfig, this);
        bookCategoryDao = new BookCategoryDao(bookCategoryDaoConfig, this);
        noteDao = new NoteDao(noteDaoConfig, this);
        quoteDao = new QuoteDao(quoteDaoConfig, this);

        registerDao(Book.class, bookDao);
        registerDao(Author.class, authorDao);
        registerDao(BookAuthor.class, bookAuthorDao);
        registerDao(Shelve.class, shelveDao);
        registerDao(BookShelve.class, bookShelveDao);
        registerDao(Category.class, categoryDao);
        registerDao(BookCategory.class, bookCategoryDao);
        registerDao(Note.class, noteDao);
        registerDao(Quote.class, quoteDao);
    }
    
    public void clear() {
        bookDaoConfig.getIdentityScope().clear();
        authorDaoConfig.getIdentityScope().clear();
        bookAuthorDaoConfig.getIdentityScope().clear();
        shelveDaoConfig.getIdentityScope().clear();
        bookShelveDaoConfig.getIdentityScope().clear();
        categoryDaoConfig.getIdentityScope().clear();
        bookCategoryDaoConfig.getIdentityScope().clear();
        noteDaoConfig.getIdentityScope().clear();
        quoteDaoConfig.getIdentityScope().clear();
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public AuthorDao getAuthorDao() {
        return authorDao;
    }

    public BookAuthorDao getBookAuthorDao() {
        return bookAuthorDao;
    }

    public ShelveDao getShelveDao() {
        return shelveDao;
    }

    public BookShelveDao getBookShelveDao() {
        return bookShelveDao;
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public BookCategoryDao getBookCategoryDao() {
        return bookCategoryDao;
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }

    public QuoteDao getQuoteDao() {
        return quoteDao;
    }

}
