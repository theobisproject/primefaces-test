package org.primefaces.test;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;

@ManagedBean(name="treeSelectionView")
@ViewScoped
public class SelectionView implements Serializable {

    private TreeNode root;
    private TreeNode[] selectedNodes;

    @ManagedProperty("#{documentService}")
    private DocumentService service;

    @PostConstruct
    public void init() {
        root = service.createCheckboxDocuments();
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode[] getSelectedNodes() {
        return selectedNodes;
    }

    public void setSelectedNodes(TreeNode[] selectedNodes) {
        this.selectedNodes = selectedNodes;
    }

    public void setService(DocumentService service) {
        this.service = service;
    }

    public void onNodeSelect(final NodeSelectEvent event) {
        TreeNode selectedTreeNode = event.getTreeNode();
        if (selectedNodes != null && selectedNodes.length > 0) {
            for (final TreeNode node : selectedNodes) {
                if (!node.getData().equals(selectedTreeNode.getData())) {
                    node.setSelected(false);
                }
            }
        }

        if (!selectedTreeNode.isSelected()) {
            selectedTreeNode.setSelected(true);
        }

        selectedNodes = new TreeNode[] { selectedTreeNode };
    }
}
