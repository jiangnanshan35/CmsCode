package com.youyue.manage_cms.dao;

import com.youyue.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    @Test
    public void testFindAll(){
        List<CmsPage> list = cmsPageRepository.findAll();
        System.out.println(list);
    }

    //分页查询
    @Test
    public void testFindPage(){
        //分页参数
        int page = 0;//开始页码 从0开始
        int size = 10;//每页显示条数
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> pages = cmsPageRepository.findAll(pageable);
        System.out.println(pages);
    }

    //修改
    @Test
    public void testUpdate(){
        //查询对象 Optional相当于是jdk1.8出现的新特性
        Optional<CmsPage> optional = cmsPageRepository.findById("5a92141cb00ffc5a448ff1a0");
        if(optional.isPresent()){//表示判断容器内内容是否为空  这种方式更加标椎 同时有提醒作用
            CmsPage cmsPage = optional.get();
            cmsPage.setPageAliase("test01");
            //修改
            cmsPageRepository.save(cmsPage);
        }
    }

    //根据页面名称进行查询
    @Test
    public void testFindByPageName(){
        CmsPage cmsPage = cmsPageRepository.findByPageName("10101.html");
        System.out.println(cmsPage);
    }
}
