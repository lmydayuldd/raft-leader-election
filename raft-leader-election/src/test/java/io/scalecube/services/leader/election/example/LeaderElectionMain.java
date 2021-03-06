package io.scalecube.services.leader.election.example;

import io.scalecube.services.Microservices;
import io.scalecube.services.leader.election.Config;
import io.scalecube.services.leader.election.RaftLeaderElection;
import io.scalecube.transport.Address;

public class LeaderElectionMain {

  /**
   * starting a leader election node.
   * @param args host and port for seed node.
   */
  public static void main(String[] args) {

    if (args.length < 2) {
      System.out.println("the application paramters must set with seed node address ");
    }

    RaftLeaderElection leaderElection1 = new RaftLeaderElection(new Config());

    Microservices node1 = Microservices.builder()
        .seeds(Address.create(args[0], Integer.parseInt(args[1])))
        .services(leaderElection1).build();

    leaderElection1.start(node1);
  }

}
