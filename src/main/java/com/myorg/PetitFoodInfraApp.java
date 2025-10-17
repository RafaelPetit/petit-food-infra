package com.myorg;

import software.amazon.awscdk.App;

public class PetitFoodInfraApp {
    public static void main(final String[] args) {
        App app = new App();

        PetitFoodVpcStack vpcStack = new PetitFoodVpcStack(app, "Vpc");

        PetitFoodClusterStack clusterStack = new PetitFoodClusterStack(app, "Cluster", vpcStack.getVpc());
        clusterStack.addDependency(vpcStack);

        PetitFoodServiceStack serviceStack = new PetitFoodServiceStack(app, "Service", null, clusterStack.getCluster());
        serviceStack.addDependency(clusterStack);

        app.synth();
    }
}

