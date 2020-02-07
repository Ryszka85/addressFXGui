package gui.guiView.guiViewUtil;

import datamodel.Address;
import datamodel.Person;
import gui.guiView.GUIListView;
import gui.guiView.GUITableView;

import java.util.List;

public class LinkViews {
    public LinkViews(GUIListView<Person> listView, GUITableView<Address> tableView) {
        listView.addSelectedItemListener((observableValue, person, selectedPerson) -> {
            GUIListView.selectedIndex = selectedPerson.getId_person();
            final List<Address> addresses = selectedPerson.getAddresses();
            tableView.getGuiDataListModel()
                    .setObservableDataList(addresses);
        });
    }
}
