package com.codified.esword.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codified.esword.model.Bible;
import com.codified.esword.model.ScriptureId;

public interface BibleRepository extends JpaRepository<Bible, ScriptureId> {

    Bible getByScriptureId(ScriptureId scriptureId);

    @Query(
        value = "select * from Bible bible where bible.book = :bookId",
        nativeQuery = true
    )
    public abstract List<Bible> getByBookId(Integer bookId);

    @Query(
        value = "select * from Bible bible where bible.book = :bookId and bible.chapter = :chapterId",
        nativeQuery = true
    )
    public abstract List<Bible> getByBookIdAndChapterId(Integer bookId, Integer chapterId);
}
