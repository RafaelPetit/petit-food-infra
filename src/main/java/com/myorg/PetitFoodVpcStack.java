package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.constructs.Construct;

public class PetitFoodVpcStack extends Stack {
    private Vpc vpc;

    public PetitFoodVpcStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public PetitFoodVpcStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        this.vpc = Vpc.Builder.create(this, "PetitFoodVps")
                .maxAzs(3)
                .build();
    }

    public Vpc getVpc() {
        return this.vpc;
    }
}


