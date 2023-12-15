package com.example.demowithtests.service.document;

import com.example.demowithtests.domain.Document;

public interface DocumentService {

    Document create(Document document);

    void deactivateAll(Integer id);
    Document addNewDocument(Document document, Integer id);

    Document getById(Integer id);

    Document handlePassport(Integer id);

    Document addImage(Integer passportId, Integer imageId);
}
