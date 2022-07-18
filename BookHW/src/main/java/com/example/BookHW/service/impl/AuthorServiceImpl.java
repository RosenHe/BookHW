package com.example.BookHW.service.impl;

import com.example.BookHW.exception.AuthorNotFoundException;
import com.example.BookHW.exception.NullParameterException;
import com.example.BookHW.model.Author;
import com.example.BookHW.model.CommonResponse;
import com.example.BookHW.repository.AuthorRepository;
import com.example.BookHW.service.AuthorService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);
    private final AuthorRepository authorRepository;

    @Override
    public CommonResponse addAuthor(String name) {
        CommonResponse response = new CommonResponse();
        if(name == null || name.length() == 0){
            log.error("String parameter {name} can't be null.");
            log.debug("To fix: Input Author name.");
            throw new NullParameterException("Author information can't be null.");
        }
        Author author = new Author();
        author.setName(name);
        authorRepository.save(author);
        response.setData(author.getAuthorId());
        return response;
    }

    @Override
    public CommonResponse getAuthor(int id) {
        CommonResponse response = new CommonResponse();
        Author author = authorRepository.findById(id).orElseThrow(()-> {
            log.error("Can't find Author id: "+ id);
            log.debug("To fix: Re-enter Author id.");
            return new AuthorNotFoundException("Can't find author id: " + id);
        });
        response.setData(author);
        return response;
    }

    @Override
    public CommonResponse updateAuthor(int id, String name) {
        CommonResponse response = new CommonResponse();
        Author author = authorRepository.findById(id).orElseThrow(()-> {
            log.error("Can't find Author id: "+ id);
            log.debug("To fix: Re-enter Author id.");
            return new AuthorNotFoundException("Can't find author id: " + id);
        });
        author.setName(name);
        authorRepository.save(author);
        response.setData(author.getName());
        return response;
    }

    @Override
    public CommonResponse deleteAuthor(int id) {
        CommonResponse response = new CommonResponse();
        Author author = authorRepository.findById(id).orElseThrow(()-> {
            log.error("Can't find Author id: "+ id);
            log.debug("To fix: Re-enter Author id.");
            return new AuthorNotFoundException("Can't find author id: " + id);
        });
        authorRepository.deleteById(id);
        response.setData("Delete Successfully.");
        return response;
    }
}
