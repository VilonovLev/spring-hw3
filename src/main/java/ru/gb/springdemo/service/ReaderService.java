package ru.gb.springdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.repository.IssueRepository;
import ru.gb.springdemo.repository.ReaderRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public Boolean addReader(Reader reader) {
        return readerRepository.addReader(reader);
    }
    public Reader getReaderById(long readrId) {
        return readerRepository.getReaderById(readrId);
    }
    public Boolean removeReaderById(long readrId) {
        return readerRepository.removeReaderById(readrId);
    }

    public List<Issue> getAllIssueReader(long readerId) {
        return issueRepository.getAllOpenIssue()
                .stream()
                .filter(issue -> issue.getReaderId() == readerId)
                .collect(Collectors.toList());
    }

    public List<Reader> getAllReaders() {
        return readerRepository.getAllReaders();
    }

}
