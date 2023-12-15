package com.example.demowithtests.service.document;

import com.example.demowithtests.domain.Document;
import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.repository.DocumentRepository;
import com.example.demowithtests.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentServiceBean implements DocumentService {

    private final DocumentRepository documentRepository;
    private final EmployeeRepository employeeRepository;

    /**
     * @param document
     * @return
     */
    @Override
    public Document create(Document document) {
        document.setExpireDate(LocalDateTime.now().plusYears(5));
        return documentRepository.save(document);
    }

    @Override
    public void deactivateAll(Integer id) {
        documentRepository.updateAllDocumentsSetIsActiveFalse(id);
    }

    @Override
    public Document addNewDocument(Document document, Integer id) {
        deactivateAll(id);
        Employee employee = employeeRepository.findFirstById(id);
        document.setEmployee(employee);
        document.setExpireDate(LocalDateTime.now().plusYears(5));
        document.setDateOfIssue(LocalDateTime.now());
        document.setIsActive(true);

        return documentRepository.save(document);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Document getById(Integer id) {
        return documentRepository.findById(id).orElseThrow();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Document handlePassport(Integer id) {
        Document document = getById(id);
        if (document.getIsHandled()) {
            throw new RuntimeException();
        } else document.setIsHandled(Boolean.TRUE);
        return documentRepository.save(document);
    }

    /**
     * @param passportId
     * @param imageId
     * @return
     */
    @Override
    public Document addImage(Integer passportId, Integer imageId) {
        return null;
    }
}
