package subway.line.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import subway.line.domain.Line;
import subway.line.dto.LineRequest;
import subway.line.dto.LineResponse;
import subway.line.repository.LineRepository;
import subway.station.domain.Station;
import subway.station.service.StationService;

@Service
public class LineService {
    private LineRepository lineRepository;
    private StationService stationService;

    public LineService(LineRepository lineRepository, StationService stationService) {
        this.lineRepository = lineRepository;
        this.stationService = stationService;
    }

    @Transactional
    public LineResponse saveLine(LineRequest request) {

        Station upStation = stationService.findById(request.getUpStationId());
        Station downStation = stationService.findById(request.getUpStationId());
        Line line = Line.of(request, upStation, downStation);



        lineRepository.save(line);
        return LineResponse.of(line);
    }
}