package com.codified.esword.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.codified.esword.model.ScriptureId;
import com.codified.esword.model.WoG;

public interface WoGRepository extends JpaRepository<WoG, ScriptureId> {

    WoG getByScriptureId(ScriptureId scriptureId);

    @Query(
        value = "select * from WoG bible where bible.book = :bookId",
        nativeQuery = true
    )
    public abstract List<WoG> getByBookId(Integer bookId);

    @Query(
        value = "select * from WoG bible where bible.book = :bookId and bible.chapter = :chapterId",
        nativeQuery = true
    )
    public abstract List<WoG> getByBookIdAndChapterId(Integer bookId, Integer chapterId);
}
