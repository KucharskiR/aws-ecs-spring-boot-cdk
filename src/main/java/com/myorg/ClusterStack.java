package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ecs.Cluster;
import software.amazon.awscdk.services.ecs.ClusterProps;
import software.amazon.awscdk.services.ecs.ContainerInsights;
import software.constructs.Construct;

public class ClusterStack extends Stack {

    private final Cluster cluster;

    public ClusterStack(final Construct scope, final String id, final StackProps props, ClusterStackProps clusterStackProps) {
        super(scope, id, props);

        this.cluster = new Cluster(this, "Cluster", ClusterProps.builder()
                .clusterName("ECommerceCluster")
                .vpc(clusterStackProps.vpc())
                .containerInsightsV2(ContainerInsights.ENHANCED)
                .build());

    }

    public Cluster getCluster() {
        return cluster;
    }
}

record ClusterStackProps(Vpc vpc) {}