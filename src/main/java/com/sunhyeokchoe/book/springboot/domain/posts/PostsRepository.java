package com.sunhyeokchoe.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Posts 엔티티 클래스로 데이터베이스에 접근 가능하게 해줄 인터페이스
public interface PostsRepository extends JpaRepository<Posts, Long> { // [#1]

}

/*
 * [#1] JpaRepository<Entity 클래스, PK 타입>
 *   - 상속시 기본적인 CRUD 메소드가 자동생성됨.
 *
 */
