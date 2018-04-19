package in.iisc.csa.sujeet.common.pubsub;

import java.util.ArrayList;
import java.util.List;

import com.google.cloud.pubsub.spi.v1.PublisherClient;
import com.google.cloud.pubsub.spi.v1.SubscriberClient;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.ReceivedMessage;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.TopicName;

public class PublishPullMessages {

	public static void publish() throws Exception {
		String projectId = "";
		String topicName = "";
		TopicName topic = TopicName.create(projectId, topicName);
		String payload = "Hellooooo!!!";
		PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8(payload)).build();
		PublisherClient publisher = PublisherClient.create();
		List<PubsubMessage> messages = new ArrayList<PubsubMessage>();
		messages.add(pubsubMessage);
		PublishResponse res = publisher.publish(topic, messages);
		List<String> resp = res.getMessageIdsList();
		System.out.println("Message Ids: " + resp);
		if (publisher != null) {
			publisher.close();
		}
	}

	public static void subscribe() throws Exception {
		String projectId = "";
		String subscriptionName = "";
		SubscriberClient subscriber = SubscriberClient.create();
		SubscriptionName subscription = SubscriptionName.create(projectId, subscriptionName);
		PullResponse res = subscriber.pull(subscription, true, 5);
		List<String> ackIds = new ArrayList<>();
		List<ReceivedMessage> msg = res.getReceivedMessagesList();
		for (ReceivedMessage val : msg) {
			System.out.println(val.getMessage().toString());
			ackIds.add(val.getAckId());
		}
		AcknowledgeRequest request = AcknowledgeRequest.newBuilder().setSubscriptionWithSubscriptionName(subscription)
				.addAllAckIds(ackIds).build();
		subscriber.acknowledge(request);
		subscriber.close();
	}

	public static void main(String[] args) throws Exception {

	}

}
