package com.tain.post.dao.impl;


import com.tain.manpower.domain.Post;
import com.tain.post.dao.PostDao;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {

    /**
     * 查询数据库中职位
     * @return
     */
    @Override
    public List<Post> query() {
        String sql = "from Post T_POST";
        List<Post> list = (List<Post>) getHibernateTemplate().find(sql);
        return list;
    }

    /**
     * 添加&&编译
     * @param post
     * @return
     */
    @Override
    public List<Post> save(Post post) {
        if ("".equals(post.getPostId())){
            getHibernateTemplate().save(post);
        }else {
            getHibernateTemplate().saveOrUpdate(post);
        }
        return null;
    }
}


