package com.spring.jpa.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService _topicService;


    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return _topicService.getAllTopics();
    }

    @RequestMapping("/topics/{topicId}")
    public Topic getTopic(@PathVariable String topicId) {
        return _topicService.getTopic(topicId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        _topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        _topicService.deleteTopic(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@PathVariable String id,@RequestBody Topic topic) {
        _topicService.updateTopic(topic);
    }
}
