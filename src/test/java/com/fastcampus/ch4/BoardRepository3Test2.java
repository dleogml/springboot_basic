//package com.fastcampus.ch4;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class BoardRepository3Test2 {
//    /*
//    @Autowired
//    private BoardRepository3 boardRepo;
//
//    @BeforeEach
//    public void testData() {
//        for (int i = 1; i <= 100; i++) {
//            Board board = new Board();
//            board.setBno((long) i);
//            board.setTitle("title" + i);
//            board.setContent("content" + i);
////            board.setWriter("writer" + (i % 5)); // writer0~4
//            board.setViewCnt((long)(Math.random()*100)); // 0~99
//            board.setInDate(new Date());
//            board.setUpDate(new Date());
//            boardRepo.save(board);
//        }
//    }
//
//    @Test
//    public void deleteTest() {
//        assertTrue(boardRepo.deleteByWriter("writer1") == 20);
//        List<Board> list = boardRepo.findByWriter("writer1");
//        assertTrue(list.size() == 0);
//    }
//
//    @Test
//    public void findTest() {
//        List<Board> list = boardRepo.findByWriter("writer1");
//        assertTrue(list.size() == 20);
//        list.forEach(System.out::println);
//    }
//
//    @Test
//    public void countTest() {
//        assertTrue(boardRepo.countAllByWriter("writer1") == 20);
//    }
//
//     */
//
//}