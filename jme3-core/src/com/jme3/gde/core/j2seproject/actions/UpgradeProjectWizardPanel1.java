package com.jme3.gde.core.j2seproject.actions;

import javax.swing.event.ChangeListener;
import org.netbeans.api.project.Project;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;
import org.openide.util.HelpCtx;



public class UpgradeProjectWizardPanel1 implements WizardDescriptor.ValidatingPanel<WizardDescriptor> {

    public UpgradeProjectWizardPanel1(Project context) {
        this.context = context;
    }
    
    /**
     * The reference to the project we work on.
     */
    private Project context;
    
    /**
     * The visual component that displays this panel. If you need to access the
     * component from this class, just use getComponent().
     */
    private UpgradeProjectVisualPanel1 component;

    // Get the visual component for the panel. In this template, the component
    // is kept separate. This can be more efficient: if the wizard is created
    // but never displayed, or not all panels are displayed, it is better to
    // create only those which really need to be visible.
    @Override
    public UpgradeProjectVisualPanel1 getComponent() {
        if (component == null) {
            component = new UpgradeProjectVisualPanel1(context);
        }
        return component;
    }

    @Override
    public HelpCtx getHelp() {
        // Show no Help button for this panel:
        return HelpCtx.DEFAULT_HELP;
        // If you have context help:
        // return new HelpCtx("help.key.here");
    }

    @Override
    public boolean isValid() {
        // If it is always OK to press Next or Finish, then:
        return true;
        // If it depends on some condition (form filled out...) and
        // this condition changes (last form field filled in...) then
        // use ChangeSupport to implement add/removeChangeListener below.
        // WizardDescriptor.ERROR/WARNING/INFORMATION_MESSAGE will also be useful.
    }

    @Override
    public void addChangeListener(ChangeListener l) {
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
    }

    @Override
    public void readSettings(WizardDescriptor wiz) {
        // use wiz.getProperty to retrieve previous panel state
    }

    @Override
    public void storeSettings(WizardDescriptor wiz) {
        UpgradeProjectVisualPanel1 pnl = (UpgradeProjectVisualPanel1)component;
        wiz.putProperty("flatUpgrade", pnl.flatUpgrade());
    }

    @Override
    public void validate() throws WizardValidationException
    {
        if (!component.getRadioButton1().isSelected() && !component.getRadioButton2().isSelected()) {
            throw new WizardValidationException(null, " Select one Upgrade-Type!", null);
        }
    }
    
}
