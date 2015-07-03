package com.oracle.truffle.llvm.nodes;

import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.source.*;

@NodeChildren({@NodeChild("leftNode"), @NodeChild("rightNode")})
public abstract class LlvmBinaryNode extends LlvmExpressionNode {

    public LlvmBinaryNode(SourceSection src) {
        super(src);
        // TODO Auto-generated constructor stub
    }

}
