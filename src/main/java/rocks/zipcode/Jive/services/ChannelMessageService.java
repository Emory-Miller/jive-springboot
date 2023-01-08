package rocks.zipcode.Jive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.zipcode.Jive.entities.Channel;
import rocks.zipcode.Jive.entities.ChannelMessage;
import rocks.zipcode.Jive.repositories.ChannelMessageRepository;

import java.util.List;

@Service
public class ChannelMessageService {

    @Autowired
    ChannelMessageRepository channelMessageRepository;


    public ChannelMessageService(ChannelMessageRepository channelMessageRepository) {
        this.channelMessageRepository = channelMessageRepository;
    }

    public List<ChannelMessage> getAllChannelMessages() {
        return channelMessageRepository.findAll();
    }

    public ChannelMessage getChannelMessageById(Long idChannelMessage) {
        return channelMessageRepository.findById(idChannelMessage).get();
    }

    public void saveChannelMessage(ChannelMessage channelMessage) {
        channelMessageRepository.save(channelMessage);
    }

    public void deleteChannelMessageById(Long idChannelMessage) {
        channelMessageRepository.deleteById(idChannelMessage);
    }

    public ChannelMessage update(Long id, ChannelMessage newChannelMessageData){
        ChannelMessage originalChannelMessage = channelMessageRepository.findById(id).get();
        originalChannelMessage.setIdChannelMessage(newChannelMessageData.getIdChannelMessage());
        originalChannelMessage.setIdUser(newChannelMessageData.getIdUser());
        originalChannelMessage.setIdChannel(newChannelMessageData.getIdChannel());
        originalChannelMessage.setMessage(newChannelMessageData.getMessage());
        return channelMessageRepository.save(originalChannelMessage);
    }
}
