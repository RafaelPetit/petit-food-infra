package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ecs.Cluster;
import software.constructs.Construct;

public class PetitFoodClusterStack extends Stack {
    private Cluster cluster;
    public PetitFoodClusterStack(final Construct scope, final String id, final Vpc vpc) {
        this(scope, id, null, vpc);
    }

    public PetitFoodClusterStack(final Construct scope, final String id, final StackProps props, final Vpc vpc) {
        super(scope, id, props);

        this.cluster = Cluster.Builder.create(this, "PetitFoodCluster")
                .clusterName("cluster-petit-food")
                .vpc(vpc)
                .build();
    }

    public Cluster getCluster() {
        return cluster;
    }
}
