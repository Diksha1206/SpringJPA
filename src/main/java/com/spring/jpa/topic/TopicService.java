package com.spring.jpa.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    // Business logic for CRUD operations here
    @Autowired
    private TopicRepository _topicRepository;


    public List<Topic> getAllTopics() {
        //return topics;
        // since findAll returns a Iterable we need to convert it into a List and the send it
        List<Topic> topics = new ArrayList<>();
        _topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return _topicRepository.findById(id).orElse(null);
    }


    public void addTopic(Topic topic) {
        //topics.add(topic);
        _topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        _topicRepository.deleteById(id);
    }

    public void updateTopic(Topic topic) {
        _topicRepository.save(topic);
    }
}
