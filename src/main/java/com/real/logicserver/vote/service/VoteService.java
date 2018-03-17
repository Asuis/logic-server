package com.real.logicserver.vote.service;

import com.real.logicserver.dto.Result;

/**
 * @author asuis
 * 投票
 */
public interface VoteService {
    public boolean addVote();
    public boolean updateVote();
    public boolean removeVote();
}
