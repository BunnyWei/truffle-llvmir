package com.oracle.truffle.llvm.nodes;

import java.io.*;

import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.instrument.ProbeNode.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;
import com.oracle.truffle.llvm.nodes.instrument.*;

public abstract class LlvmStatementNode extends Node {

    public LlvmStatementNode(SourceSection src) {
        super(src);
    }

    /**
     * Execute this node as as statement, where no return value is necessary.
     */
    public abstract void executeVoid(VirtualFrame frame);

    public LlvmStatementNode getNonWrapperNode() {
        return this;
    }

    @Override
    public String toString() {
        return formatSourceSection(this);
    }

    /**
     * Formats a source section of a node in human readable form. If no source section could be
     * found it looks up the parent hierarchy until it finds a source section. Nodes where this was
     * required append a <code>'~'</code> at the end.
     *
     * @param node the node to format.
     * @return a formatted source section string
     */
    private static String formatSourceSection(Node node) {
        if (node == null) {
            return "<unknown>";
        }
        SourceSection section = node.getSourceSection();
        boolean estimated = false;
        if (section == null) {
            section = node.getEncapsulatingSourceSection();
            estimated = true;
        }

        if (section == null || section.getSource() == null) {
            return "<unknown source>";
        } else {
            String sourceName = new File(section.getSource().getName()).getName();
            int startLine = section.getStartLine();
            return String.format("%s:%d%s", sourceName, startLine, estimated ? "~" : "");
        }
    }

    @Override
    public boolean isInstrumentable() {
        return true;
    }

/*
 * @Override public WrapperNode createWrapperNode() { return new LlvmStatementWrapperNode(this); }
 */
}
