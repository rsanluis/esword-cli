package com.codified.esword.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.codified.esword.model.Bible;
import com.codified.esword.model.ScriptureId;

@Service
public interface BibleDAO extends JpaRepository<Bible, ScriptureId> {

    Bible getByScriptureId(ScriptureId scriptureId);

    @Query(
        value = "select * from Bible bible where bible.book = :bookId",
        nativeQuery = true
    )
    public abstract List<Bible> findByBookId(@Param("bookId") Integer bookId);

    @Query(
        value = "select * from Bible bible where bible.book = :bookId and bible.chapter = :chapterId",
        nativeQuery = true
    )
    public abstract List<Bible> findByBookIdAndChapterId(@Param("bookId") Integer bookId, @Param("chapterId") Integer chapterId);
}
