package ai.sn.converters;


import ai.sn.dto.MessageDTO;
import ai.sn.entities.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageDtoToMessageConverter implements Converter<MessageDTO, Message> {

    private final UserDtoToUserConverter userDtoToUserConverter;

    @Override
    public Message convert(MessageDTO messageDTO) {
        if (messageDTO == null) {
            return null;
        }

        return Message.builder()
                .time(messageDTO.getTime())
                .message(messageDTO.getMessage())
                .sender(userDtoToUserConverter.convert(messageDTO.getSender()))
                .receiver(userDtoToUserConverter.convert(messageDTO.getReceiver()))
                .build();
    }
}

