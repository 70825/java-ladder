package ladder.domain;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private static final int MINIMUM_PLAYER_SIZE = 2;
    private static final int MAXIMUM_PLAYER_SIZE = 10;
    private static final String PLAYER_SIZE_ERROR_MESSAGE =
            "플레이어는 " + MINIMUM_PLAYER_SIZE + "명 이상, " + MAXIMUM_PLAYER_SIZE + "명 이하만 가능합니다. 현재 입력한 플레이어 수는 {0}명 입니다.";
    private static final String DUPLICATE_PLAYER_ERROR_MESSAGE = "플레이어 이름은 중복되면 안됩니다.";

    private final List<Player> players;
    private final List<Integer> positions;

    public Players(final List<String> names) {
        this(names, IntStream.range(0, names.size()).boxed().collect(Collectors.toList()));
    }

    public Players(final List<String> names, final List<Integer> positions) {
        final List<Player> players = generatePlayers(names);
        validate(players);
        this.players = players;
        this.positions = positions;
    }

    private List<Player> generatePlayers(final List<String> names) {
        return names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private void validate(final List<Player> players) {
        validatePlayerSize(players);
        validateDuplicatePlayer(players);
    }

    private void validatePlayerSize(final List<Player> players) {
        if (isSmallSize(players) || isLargeSize(players)) {
            throw new IllegalArgumentException(MessageFormat.format(PLAYER_SIZE_ERROR_MESSAGE, players.size()));
        }
    }

    private boolean isSmallSize(final List<Player> players) {
        return MINIMUM_PLAYER_SIZE > players.size();
    }

    private boolean isLargeSize(final List<Player> players) {
        return MAXIMUM_PLAYER_SIZE < players.size();
    }

    private void validateDuplicatePlayer(final List<Player> players) {
        final Set<Player> uniquePlayers = new HashSet<>(players);

        if (isDuplicate(players, uniquePlayers)) {
            throw new IllegalArgumentException(DUPLICATE_PLAYER_ERROR_MESSAGE);
        }
    }

    private boolean isDuplicate(final List<Player> players, final Set<Player> uniquePlayers) {
        return players.size() != uniquePlayers.size();
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Integer> getPositions() {
        return positions;
    }

    public int numberOfPlayers() {
        return players.size();
    }

    public int findPositionByName(String value) {
        return positions.get(players.indexOf(new Player(value)));
    }
}
