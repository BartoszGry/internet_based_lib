package com.grygierczyk.system_repo;

import com.grygierczyk.entity.ExternalBibRecord;

import java.util.List;

public interface ExternalApiService {
    List<ExternalBibRecord> getExternalBibRecords();
}
