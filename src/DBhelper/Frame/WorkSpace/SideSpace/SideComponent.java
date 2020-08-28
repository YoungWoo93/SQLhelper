package DBhelper.Frame.WorkSpace.SideSpace;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;

import javax.swing.JPanel;

import DBhelper.*;

public class SideComponent extends JPanel{
    public JPanel dbStructureComponent;
    public JPanel combineFunctionComponent;

    Model model;
    Cantrol controller;
    
    public SideComponent(Model m, Cantrol c) {
		model = m;
		controller = c;
        //JLabel jtestlabel = new JLabel("WorkComponent");
        //add(jtestlabel);
        
        // setLayout(new GridBagLayout());
        // setBorder(new LineBorder(Color.black,1));

        // dbStructureComponent = new DBStructureComponent();
        // combineFunctionComponent = new CombineFunctionComponent();

        // add(dbStructureComponent);
        // add(combineFunctionComponent);

        dbStructureComponent = new DBStructureComponent(m,c);
        combineFunctionComponent = new CombineFunctionComponent(m,c);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        setLayout(gbl);


        addGrid(gbl, gbc, dbStructureComponent, 0, 0, 1, 1, 1, 4);
        addGrid(gbl, gbc, combineFunctionComponent, 0, 1, 1, 1, 1, 0);

    }

    private void addGrid(GridBagLayout gbl, GridBagConstraints gbc, Component c, int gridx, int gridy, int gridwidth, int gridheight, int weightx, int weighty) {
            gbc.gridx = gridx;
            gbc.gridy = gridy;
            gbc.gridwidth = gridwidth;
            gbc.gridheight = gridheight;
            gbc.weightx = weightx;
            gbc.weighty = weighty;
            gbl.setConstraints(c, gbc);
            add(c);
      }
}