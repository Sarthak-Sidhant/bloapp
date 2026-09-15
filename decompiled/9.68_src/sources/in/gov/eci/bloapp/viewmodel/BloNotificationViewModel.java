package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.repository.BloNotificationRepo;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class BloNotificationViewModel extends ViewModel {
    public BloNotificationRepo requestWheelchairRepository;

    @Inject
    public BloNotificationViewModel(BloNotificationRepo requestWheelchairRepository) {
        this.requestWheelchairRepository = requestWheelchairRepository;
    }

    public int getCount(String partNo) {
        return this.requestWheelchairRepository.getCount(partNo);
    }

    public void updateCount(String partNo, int count) {
        this.requestWheelchairRepository.updateCount(partNo, count);
    }
}
