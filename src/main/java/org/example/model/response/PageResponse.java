package org.example.model.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2021/2/18 12:21 上午
 */
public class PageResponse extends OperationResponse {
    @Getter
    @Setter
    private boolean first;

    @Getter
    @Setter
    private boolean last;

    @Getter
    @Setter
    private int currentPageNumber;

    @Getter
    @Setter
    private int itemInPage;

    @Getter
    @Setter

    private int pageSize;

    @Getter
    @Setter
    private int totalPages;

    @Getter
    @Setter
    private long totalItems;

    @Getter
    @Setter
    private Sort sort;

    private List items;

    public void setPageStats(Page pg, boolean setDefaultMessage) {
        this.first = pg.isFirst();
        this.last = pg.isLast();
        this.currentPageNumber = pg.getNumber();
        this.itemInPage = pg.getNumber();
        this.pageSize = pg.getSize();
        this.totalPages = pg.getTotalPages();
        this.totalItems = pg.getTotalElements();
        this.sort = pg.getSort();
        if (setDefaultMessage == true) {
            this.setOperationStatus(ResponseStatusEnum.SUCCESS);
            this.setOperationMessage("Page " + (pg.getNumber() + 1) + " of " + pg.getTotalPages());
        }
    }

    public void setPageTotal(int count, boolean setDetaulMessage) {
        this.first = true;
        this.last = true;
        this.itemInPage = count;
        this.totalItems = count;
        this.totalPages = 1;
        this.pageSize = count;
        if (setDetaulMessage == true) {
            this.setOperationStatus(ResponseStatusEnum.SUCCESS);
            this.setOperationMessage("Total " + count + " items");
        }
    }
}
