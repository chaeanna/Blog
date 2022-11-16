package com.blog;


import com.blog.domain.BlogDTO;
import com.blog.mapper.BlogMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.List;

@SpringBootTest
public class MappersTests {

    @Autowired
    private BlogMapper blogMapper;

    @Test
    public void testOfInsert() {
        BlogDTO params = new BlogDTO();
        params.setTitle("Post");
        params.setContent("Content");

        int result = blogMapper.insertBlog(params);
        System.out.println("result : " + result);
    }

    @Test
    public void testOfSelectDetail() {
        BlogDTO blog = blogMapper.selectBlogDetail((long) 1);
        try {
            String blogJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(blog);
            System.out.println("======================================");
            System.out.println(blogJson);
            System.out.println("======================================");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOfUpdate() {
        BlogDTO params = new BlogDTO();
        params.setTitle("LOG CABIN");
        params.setContent("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.");
        params.setImage("https://startbootstrap.github.io/startbootstrap-freelancer/assets/img/portfolio/cabin.png");
        params.setIdx((long) 1);

        int result = blogMapper.updateBlog(params);
        if(result == 1) {
            BlogDTO blog = blogMapper.selectBlogDetail((long) 1);
            try {
                String blogJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(blog);
                System.out.println("======================================");
                System.out.println(blogJson);
                System.out.println("======================================");

            } catch(JsonProcessingException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void testOfDelete() {
        int result = blogMapper.deleteBlog((long) 1);
        if(result == 1) {
            BlogDTO blog = blogMapper.selectBlogDetail((long) 1);
            try {
                String blogJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(blog);
                System.out.println("======================================");
                System.out.println(blogJson);
                System.out.println("======================================");
            } catch(JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

//    @Test
//    public void testSelectList() {
//        List<BlogDTO> blogList = blogMapper.selectBlogList();
//        if(CollectionUtils.isEmpty(blogList) == false) {
//            for(BlogDTO blog : blogList) {
//                System.out.println("======================================");
//                System.out.println(blog.getTitle());
//                System.out.println(blog.getContent());
//                System.out.println(blog.getImage());
//                System.out.println("======================================");
//
//            }
//        }
//    }
}
