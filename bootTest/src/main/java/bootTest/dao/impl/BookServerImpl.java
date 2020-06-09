package bootTest.dao.impl;

//@Service
//public class BookServerImpl implements BookServer {
////    private static final String NAMESPACE = "dao.impl.BookDaoImpl.";
//
//    @Autowired
//    private BookMapper bookMapper;
//
//
//    @Override
//    public List<Book> findAll() {
//        return bookMapper.findAll();
//    }

//    @Resource
//    private SqlSessionTemplate sqlSessionTemplate;
//
//    public int insert(BaseBook record) {
//        return sqlSessionTemplate.insert(NAMESPACE + "insert", record);
//    }
//
//    public Book selectOne(String pk) {
//        return sqlSessionTemplate.selectOne(NAMESPACE + "selectByPk", pk);
//    }
//
//    public Book selectOne(BookCriteria criteria) {
//        return sqlSessionTemplate.selectOne(NAMESPACE + "selectByCriteria", criteria);
//    }
//
//    public List<Book> selectList(BookCriteria criteria) {
//        return sqlSessionTemplate.selectList(NAMESPACE + "selectList", criteria);
//    }
//
//    public int count(BookCriteria criteria) {
//        return sqlSessionTemplate.selectOne(NAMESPACE + "count", criteria);
//    }
//
//    public int update(BaseBook record) {
//        return sqlSessionTemplate.update(NAMESPACE + "updateByPk", record);
//    }
//
//    public int update(BaseBook record, BookCriteria criteria) {
//        Map<String, Object> param = new HashMap<>();
//        param.put("record", record);
//        param.put("criteria", criteria);
//        return sqlSessionTemplate.update(NAMESPACE + "updateByCriteria", param);
//    }
//
//    public int delete(String pk) {
//        return sqlSessionTemplate.delete(NAMESPACE + "deleteByPk", pk);
//    }
//
//    public int delete(BookCriteria criteria) {
//        return sqlSessionTemplate.delete(NAMESPACE + "deleteByCriteria", criteria);
//    }
//}