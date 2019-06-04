package com.jamesdube.hogwarts.subjectservice.business.service;

import com.jamesdube.hogwarts.subjectservice.data.domain.Subject;
import com.jamesdube.hogwarts.subjectservice.data.repository.SubjectRepository;
import com.jamesdube.hogwarts.subjectservice.utils.SubjectSpecification;
import com.jamesdube.hogwarts.subjectservice.utils.SubjectWrapper;
import com.jamesdube.hogwarts.subjectservice.utils.Type;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject create(String code, String name, Type type){

        Subject newSubject = new Subject(
                code,name,type);

        Subject createdSubject = subjectRepository.save(newSubject);

        return createdSubject;

    }

    public List<Subject> all(SubjectWrapper subjectWrapper){

        return subjectRepository.findAll(SubjectSpecification.filterByWrapper(subjectWrapper));

    }

    public Subject find(Long id) {

        Optional<Subject> optionalSubject = subjectRepository.findById(id);

        return optionalSubject.orElse(null);
    }

    public Subject edit(Long id, String code, String name) {

        Optional<Subject> optionalSubject = subjectRepository.findById(id);

        if (!optionalSubject.isPresent()) return null;

        Subject subject = optionalSubject.get();

        subject.setCode(code);
        subject.setName(name);

        return subjectRepository.save(subject);

    }
}
